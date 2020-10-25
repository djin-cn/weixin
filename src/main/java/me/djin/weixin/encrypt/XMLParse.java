/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package me.djin.weixin.encrypt;

import java.io.IOException;
import java.io.StringReader;
import java.rmi.UnexpectedException;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import me.djin.weixin.pojo.cgi.AuthorizeInfo;
import me.djin.weixin.pojo.cgi.ComponentTicket;
import me.djin.weixin.pojo.cgi.EventMessageModel;
import me.djin.weixin.pojo.common.EventType;

/**
 * XMLParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
public class XMLParse {
	public static final String KEY_ENCRYPT = "Encrypt";
	public static final String KEY_TOUSERNAME = "ToUserName";

	/**
	 * 解析事件消息,包括但不限于验证票据事件/授权变更事件
	 * 
	 * @param plaintext 解密后的明文
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static EventMessageModel parse2EventMessage(String plaintext)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder db = buildDocumentBuilder();
		StringReader sr = new StringReader(plaintext);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);
		Element root = document.getDocumentElement();
		NodeList appIdNodeList = root.getElementsByTagName(EventMessageModel.APPID_NODE);
		NodeList createTimeNodelist = root.getElementsByTagName(EventMessageModel.CREATETIME_NODE);
		NodeList infoTypeNodelist = root.getElementsByTagName(EventMessageModel.INFOTYPE_NODE);

		Node infoTypeNode = infoTypeNodelist.item(0);
		if (infoTypeNode == null) {
			throw new UnexpectedException(String.format("未能正确获取到%1$s节点, 此消息类型尚未实现", EventMessageModel.INFOTYPE_NODE));
		}
		String infoType = infoTypeNodelist.item(0).getTextContent();

		// 验证票据事件消息
		if (EventType.COMPONENT_VERIFY_TICKET.name().equalsIgnoreCase(infoType)) {
			NodeList componentVerifyTicketNodelist = root
					.getElementsByTagName(ComponentTicket.COMPONENTVERIFYTICKET_NODE);
			ComponentTicket componentTicket = new ComponentTicket();
			componentTicket.setAppId(appIdNodeList.item(0).getTextContent());
			componentTicket.setCreateTime(new Date(Long.valueOf(createTimeNodelist.item(0).getTextContent())));
			componentTicket.setInfoType(EventType.COMPONENT_VERIFY_TICKET);
			componentTicket.setComponentVerifyTicket(componentVerifyTicketNodelist.item(0).getTextContent());
			return componentTicket;
		}

		// 取消授权/更新授权/授权成功的事件消息
		NodeList authorizerAppIdNodeList = root.getElementsByTagName(AuthorizeInfo.AUTHORIZERAPPID_NODE);
		NodeList authorizationCodeNodelist = root.getElementsByTagName(AuthorizeInfo.AUTHORIZATIONCODE_NODE);
		NodeList authorizationCodeExpiredTimeNodelist = root
				.getElementsByTagName(AuthorizeInfo.AUTHORIZATIONCODEEXPIREDTIME_NODE);
		NodeList preAuthCodeNodelist = root.getElementsByTagName(AuthorizeInfo.PREAUTHCODE_NODE);
		AuthorizeInfo authorizeInfo = new AuthorizeInfo();
		authorizeInfo.setAppId(appIdNodeList.item(0).getTextContent());
		authorizeInfo.setCreateTime(new Date(Long.valueOf(createTimeNodelist.item(0).getTextContent())));
		authorizeInfo.setAuthorizationCode(authorizationCodeNodelist.item(0).getTextContent());
		authorizeInfo.setAuthorizationCodeExpiredTime(
				Long.valueOf(authorizationCodeExpiredTimeNodelist.item(0).getTextContent()));
		authorizeInfo.setAuthorizerAppid(authorizerAppIdNodeList.item(0).getTextContent());
		authorizeInfo.setPreAuthCode(preAuthCodeNodelist.item(0).getTextContent());
		if (EventType.AUTHORIZED.name().equalsIgnoreCase(infoType)) {
			authorizeInfo.setInfoType(EventType.AUTHORIZED);
		} else if (EventType.UNAUTHORIZED.name().equalsIgnoreCase(infoType)) {
			authorizeInfo.setInfoType(EventType.UNAUTHORIZED);
		} else if (EventType.UPDATEAUTHORIZED.name().equalsIgnoreCase(infoType)) {
			authorizeInfo.setInfoType(EventType.UPDATEAUTHORIZED);
		} else {
			throw new UnexpectedException(
					"unexpected weixin infotype:" + infoType + ", please reference to EventType enum");
		}
		return authorizeInfo;
	}

	/**
	 * 提取出xml数据包中的加密消息, 一般用于接收微信安全模式推送的XML消息, 包含两个元素:Encrypt,ToUserName;
	 *
	 * @see XMLParse#extract2Map(String)
	 * @param xmltext 待提取的xml字符串
	 * @return 提取出的加密消息字符串
	 * @throws AesException
	 */
	@Deprecated
	public static Object[] extract(String xmltext) throws AesException {
		Object[] result = new Object[3];
		try {
			DocumentBuilder db = buildDocumentBuilder();
			StringReader sr = new StringReader(xmltext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("ToUserName");
			result[0] = 0;
			result[1] = nodelist1.item(0).getTextContent();
			result[2] = nodelist2.item(0).getTextContent();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseXmlError);
		}
	}

	/**
	 * 提取微信发送的xml文本消息
	 * 
	 * @param xmltext
	 * @return
	 * @throws AesException
	 */
	public static HashMap<String, String> extract2Map(String xmltext) throws AesException {
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			DocumentBuilder db = buildDocumentBuilder();
			StringReader sr = new StringReader(xmltext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList list = root.getChildNodes();
			int length = list.getLength();
			String key, value;
			for (int i = 0; i < length; i++) {
				Node node = list.item(i);
				key = node.getNodeName();
				value = node.getTextContent();
				map.put(key, value);
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseXmlError);
		}
	}

	/**
	 * 生成xml消息
	 * 
	 * @param encrypt   加密后的消息密文
	 * @param signature 安全签名
	 * @param timestamp 时间戳
	 * @param nonce     随机字符串
	 * @return 生成的xml字符串
	 */
	public static String generate(String encrypt, String signature, String timestamp, String nonce) {

		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
				+ "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n" + "<TimeStamp>%3$s</TimeStamp>\n"
				+ "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
		return String.format(format, encrypt, signature, timestamp, nonce);

	}

	/**
	 * 生成DocumentBuilder实例
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 */
	private static DocumentBuilder buildDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		dbf.setXIncludeAware(false);
		dbf.setExpandEntityReferences(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db;
	}
}

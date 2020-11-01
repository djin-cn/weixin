/**
 * 
 */
package me.djin.weixin;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import me.djin.weixin.encrypt.AesException;
import me.djin.weixin.encrypt.WXBizMsgCrypt;
import me.djin.weixin.encrypt.XMLParse;
import me.djin.weixin.pojo.cgi.ComponentInfo;
import me.djin.weixin.pojo.cgi.EventMessageModel;
import me.djin.weixin.pojo.common.EventType;

/**
 * @author djin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxRequestProcessTest {
	private Logger logger = me.djin.weixin.util.Constant.LOGGER;
	private MockHttpServletRequest request = new MockHttpServletRequest();

	@Test
	public void decryptEventRequest() throws IOException, AesException, ParserConfigurationException, SAXException {
		ComponentInfo componentInfo = new ComponentInfo();
		componentInfo.setAppId(Constant.APPID);
		componentInfo.setEncodingAESKey(Constant.ENCODING_AES_KEY);
		componentInfo.setToken(Constant.TOKEN);
		logger.info(componentInfo.toString());

		String nonce = "xxxxxxxxxx";
		String timeStamp = "1409304348";
		String replyMsg = "<xml>\r\n" + "  <AppId>" + Constant.APPID + "</AppId>\r\n"
				+ "  <CreateTime>1413192760</CreateTime>\r\n" + "  <InfoType>"
				+ EventType.AUTHORIZED.name().toLowerCase() + "</InfoType>\r\n" + "  <AuthorizerAppid>" + Constant.APPID
				+ "</AuthorizerAppid>\r\n" + "  <AuthorizationCode>0123456789</AuthorizationCode>\r\n"
				+ "  <AuthorizationCodeExpiredTime>7200</AuthorizationCodeExpiredTime>\r\n"
				+ "  <PreAuthCode>9876543210</PreAuthCode>\r\n" + "</xml>";
		WXBizMsgCrypt crypt = new WXBizMsgCrypt(Constant.TOKEN, Constant.ENCODING_AES_KEY, Constant.APPID);
		String encryptMsg = crypt.encryptMsg(replyMsg, timeStamp, nonce);
		logger.info("加密后内容: {}", encryptMsg);

		HashMap<String, String> map = XMLParse.extract2Map(encryptMsg);
		logger.info("xml提取到消息: {}", map.toString());

		request.addParameter("timestamp", timeStamp);
		request.addParameter("nonce", nonce);
		request.addParameter("encrypt_type", "aes");
		request.addParameter("msg_signature", map.get("MsgSignature"));
		request.setMethod("post");
		request.setContent(encryptMsg.getBytes());
		EventMessageModel eventMessage = WxRequestProcess.decryptEventRequest(request, componentInfo);
		logger.info("解密后内容: {}", eventMessage.toString());
		assertNotNull(eventMessage);
		assertEquals(eventMessage.getInfoType(), EventType.AUTHORIZED);

	}

	@Test
	public void decryptPhone() throws AesException {
		System.out.println("没有实现对应的加密算法, 暂时未能测试此接口");
	}
}

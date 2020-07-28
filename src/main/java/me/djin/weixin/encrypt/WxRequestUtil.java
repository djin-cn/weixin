/**
 * 
 */
package me.djin.weixin.encrypt;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import me.djin.weixin.pojo.cgi.ComponentInfo;
import me.djin.weixin.pojo.cgi.EventMessageModel;
import me.djin.weixin.pojo.sns.Phone;
import me.djin.weixin.util.Constant;

/**
 * @author djin
 * 
 *         TODO:
 */
public class WxRequestUtil {
	/**
	 * 解密微信第三方平台事件消息,如:验证票据/授权变更推送<br/>
	 * 注意:接收到请求后需要返回字符串success
	 * 
	 * @param request 微信推送的请求
	 * @return
	 * @throws IOException                  request流内容读取失败
	 * @throws AesException                 aes解密失败
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static EventMessageModel decryptEventRequest(ServletRequest request, ComponentInfo componentInfo)
			throws IOException, AesException, ParserConfigurationException, SAXException {
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"微信事件消息解析ing...");

		String msgSignature = getMsgSignature(request);
		String nonce = getNonce(request);
		String timeStamp = getTimeStamp(request);
		String postData = getPostData(request);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"signature:" + msgSignature);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"nonce:" + nonce);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"timeStamp:" + timeStamp);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"postData:" + postData);

		WXBizMsgCrypt wxCrypt = new WXBizMsgCrypt(componentInfo.getToken(), componentInfo.getEncodingAESKey(),
				componentInfo.getAppId());
		String msgPlaintext = wxCrypt.decryptMsg(msgSignature, timeStamp, nonce, postData);
		EventMessageModel model = XMLParse.parse2EventMessage(msgPlaintext);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestUtil.class.getName(), "decryptEventRequest",
				"eventMessage:" + model.toString());
		return model;
	}

	/**
	 * 解密微信手机号信息,
	 * 
	 * 参考{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html}
	 * 
	 * @param encryptData 加密的手机号信息
	 * @param iv          加密算法的初始向量,
	 *                    详细将{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/signature.html#%E5%8A%A0%E5%AF%86%E6%95%B0%E6%8D%AE%E8%A7%A3%E5%AF%86%E7%AE%97%E6%B3%95}
	 * @param cloudId     敏感数据对应的云 ID，开通云开发的小程序才会返回，可通过云调用直接获取开放数据,
	 *                    详细见{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/signature.html#method-cloud}
	 * @return
	 */
	public static Phone decryptPhone(String encryptData, String iv, String cloudId) {
		// TODO 手机号码解密
		return null;
	}

	/**
	 * 获取msg_signature
	 * 
	 * @param request
	 * @return
	 */
	private static String getMsgSignature(ServletRequest request) {
		return request.getParameter(Constant.MSG_SIGNATURE_KEY);
	}

	/**
	 * 获取timestamp
	 * 
	 * @param request
	 * @return
	 */
	private static String getTimeStamp(ServletRequest request) {
		return request.getParameter(Constant.TIMESTAMP_KEY);
	}

	/**
	 * 获取nonce
	 * 
	 * @param request
	 * @return
	 */
	private static String getNonce(ServletRequest request) {
		return request.getParameter(Constant.NONCE_KEY);
	}

	/**
	 * 获取POST请求数据
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private static String getPostData(ServletRequest request) throws IOException {
		return IOUtils.toString(request.getReader());
	}
}

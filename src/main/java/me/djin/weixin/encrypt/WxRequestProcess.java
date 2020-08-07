/**
 * 
 */
package me.djin.weixin.encrypt;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import me.djin.weixin.pojo.cgi.ComponentInfo;
import me.djin.weixin.pojo.cgi.EventMessageModel;
import me.djin.weixin.pojo.sns.Phone;
import me.djin.weixin.util.Constant;

/**
 * 微信请求处理工具类
 * 
 * @author djin
 */
public class WxRequestProcess {
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
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"微信事件消息解析ing...");

		String msgSignature = getMsgSignature(request);
		String nonce = getNonce(request);
		String timeStamp = getTimeStamp(request);
		String postData = getPostData(request);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"signature:" + msgSignature);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"nonce:" + nonce);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"timeStamp:" + timeStamp);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"postData:" + postData);

		WXBizMsgCrypt wxCrypt = new WXBizMsgCrypt(componentInfo.getToken(), componentInfo.getEncodingAESKey(),
				componentInfo.getAppId());
		String msgPlaintext = wxCrypt.decryptMsg(msgSignature, timeStamp, nonce, postData);
		EventMessageModel model = XMLParse.parse2EventMessage(msgPlaintext);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"eventMessage:" + model.toString());
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"微信事件消息解析结束");
		return model;
	}

	/**
	 * 解密微信手机号信息,
	 * 
	 * 参考{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html}
	 * 
	 * @param sessionKey  用户登录后通过微信获取的令牌
	 * @param encryptData 加密的手机号信息
	 * @param iv          加密算法的初始向量,
	 *                    详细将{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/signature.html#%E5%8A%A0%E5%AF%86%E6%95%B0%E6%8D%AE%E8%A7%A3%E5%AF%86%E7%AE%97%E6%B3%95}
	 * @param cloudId     敏感数据对应的云 ID，开通云开发的小程序才会返回，可通过云调用直接获取开放数据,
	 *                    详细见{@link https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/signature.html#method-cloud}
	 * @return
	 * @throws AesException
	 */
	public static Phone decryptPhone(String sessionKey, String encryptData, String iv, String cloudId)
			throws AesException {
		Constant.LOGGER.debug(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptPhone", "微信手机号码解析ing...:");
		if (cloudId != null) {
			throw new UnsupportedOperationException("尚未实现通过微信开放平台云ID获取手机号");
		}
		Constant.LOGGER.debug(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptPhone",
				"sessionKey:" + sessionKey);
		Constant.LOGGER.debug(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptPhone", "iv:" + iv);
		Constant.LOGGER.debug(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptPhone",
				"encryptData:" + encryptData);
		WXBizMsgCrypt wxCrypt = new WXBizMsgCrypt("", sessionKey, "");
		String decryptMsg = wxCrypt.decryptUnsignedMsg(encryptData, iv);
		Gson gson = new Gson();
		Phone phone = gson.fromJson(decryptMsg, Phone.class);
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				phone.toString());
		Constant.LOGGER.info(Constant.LOG_FORMAT, WxRequestProcess.class.getName(), "decryptEventRequest",
				"微信手机号码解析结束");
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

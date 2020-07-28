package me.djin.weixin.pojo.cgi;

/**
 * 第三方平台信息, 包括:<br/>
 * 公众号第三方平台的 token（申请公众号第三方平台时填写的接收消息的校验 token）<br/>
 * 公众号第三方平台的 appid<br/>
 * 公众号第三方平台的 EncodingAESKey（申请公众号第三方平台时填写的接收消息的加密 symmetric_key）<br/>
 * 
 * @author djin
 *
 */
public class ComponentInfo {
	/**
	 * 公众号第三方平台的 appid
	 */
	private String appId;
	/**
	 * 公众号第三方平台的 token
	 */
	private String token;
	/**
	 * 公众号第三方平台的 encodingAESKey
	 */
	private String encodingAESKey;

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the encodingAESKey
	 */
	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	/**
	 * @param encodingAESKey the encodingAESKey to set
	 */
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	@Override
	public String toString() {
		return "ComponentInfo [appId=" + appId + ", token=" + token + ", encodingAESKey=" + encodingAESKey + "] "
				+ super.toString();
	}
}

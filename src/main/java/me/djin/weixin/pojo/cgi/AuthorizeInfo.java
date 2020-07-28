/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import me.djin.weixin.util.Constant;
import me.djin.weixin.util.StringUtils;

/**
 * 授权信息,授权成功和更新授权事件除事件类型外其他内容一致, 取消授权只有AuthorizerAppid字段
 * 
 * @author djin
 */
public class AuthorizeInfo extends EventMessageModel {
	/**
	 * xml中AuthorizerAppid节点
	 */
	public static final String AUTHORIZERAPPID_NODE = "AuthorizerAppid";
	/**
	 * xml中AuthorizationCode节点
	 */
	public static final String AUTHORIZATIONCODE_NODE = "AuthorizationCode";
	/**
	 * xml中AuthorizationCodeExpiredTime节点
	 */
	public static final String AUTHORIZATIONCODEEXPIREDTIME_NODE = "AuthorizationCodeExpiredTime";
	/**
	 * xml中PreAuthCode节点
	 */
	public static final String PREAUTHCODE_NODE = "PreAuthCode";
	/**
	 * 公众号或小程序的 appid
	 */
	private String authorizerAppid;
	/**
	 * 授权码，可用于获取授权信息
	 */
	private String authorizationCode;
	/**
	 * 授权码过期时间,单位秒
	 */
	private Long authorizationCodeExpiredTime;
	/**
	 * 预授权码
	 */
	private String preAuthCode;

	/**
	 * @return the authorizerAppid
	 */
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	/**
	 * @param authorizerAppid the authorizerAppid to set
	 */
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	/**
	 * @return the authorizationCode
	 */
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	/**
	 * @param authorizationCode the authorizationCode to set
	 */
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	/**
	 * @return the authorizationCodeExpiredTime
	 */
	public Long getAuthorizationCodeExpiredTime() {
		return authorizationCodeExpiredTime;
	}

	/**
	 * @param authorizationCodeExpiredTime the authorizationCodeExpiredTime to set
	 */
	public void setAuthorizationCodeExpiredTime(Long authorizationCodeExpiredTime) {
		this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
	}

	/**
	 * @return the preAuthCode
	 */
	public String getPreAuthCode() {
		return preAuthCode;
	}

	/**
	 * @param preAuthCode the preAuthCode to set
	 */
	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}

	@Override
	public String toString() {
		return "AuthorizeInfo [authorizerAppid=" + authorizerAppid + ", authorizationCode="
				+ StringUtils.getMaskString(authorizationCode, Constant.MASK_STRING) + ", authorizationCodeExpiredTime="
				+ authorizationCodeExpiredTime + ", preAuthCode="
				+ StringUtils.getMaskString(preAuthCode, Constant.MASK_STRING) + "] " + super.toString();
	}
}

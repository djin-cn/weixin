package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiAuthorizerTokenDto {
	/**
	 * 令牌
	 */
	private String component_access_token;
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;
	/**
	 * 授权方 appid
	 */
	private String authorizer_appid;
	/**
	 * 刷新令牌，获取授权信息时得到
	 */
	private String authorizer_refresh_token;

	/**
	 * @return the component_access_token
	 */
	public String getComponent_access_token() {
		return component_access_token;
	}

	/**
	 * @param component_access_token the component_access_token to set
	 */
	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	/**
	 * @return the component_appid
	 */
	public String getComponent_appid() {
		return component_appid;
	}

	/**
	 * @param component_appid the component_appid to set
	 */
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

	/**
	 * @return the authorizer_appid
	 */
	public String getAuthorizer_appid() {
		return authorizer_appid;
	}

	/**
	 * @param authorizer_appid the authorizer_appid to set
	 */
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

	/**
	 * @return the authorizer_refresh_token
	 */
	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}

	/**
	 * @param authorizer_refresh_token the authorizer_refresh_token to set
	 */
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}

	@Override
	public String toString() {
		return "ApiAuthorizerTokenDto [component_access_token=" + component_access_token + ", component_appid="
				+ component_appid + ", authorizer_appid=" + authorizer_appid + ", authorizer_refresh_token="
				+ authorizer_refresh_token + "] " + super.toString();
	}
}

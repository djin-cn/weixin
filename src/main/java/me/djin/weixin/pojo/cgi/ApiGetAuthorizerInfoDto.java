package me.djin.weixin.pojo.cgi;

/**
 * 
 * @author djin
 *
 */
public class ApiGetAuthorizerInfoDto {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;
	/**
	 * 授权方 appid
	 */
	private String authorizer_appid;

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

	@Override
	public String toString() {
		return "ApiGetAuthorizerInfoDto [component_appid=" + component_appid + ", authorizer_appid=" + authorizer_appid
				+ "] " + super.toString();
	}
}

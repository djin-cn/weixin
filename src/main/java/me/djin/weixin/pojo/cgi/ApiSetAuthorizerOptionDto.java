/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiSetAuthorizerOptionDto extends AuthorizerOptionInfo {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;

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

	@Override
	public String toString() {
		return "ApiSetAuthorizerOptionDto [component_appid=" + component_appid + "] " + super.toString();
	}
}

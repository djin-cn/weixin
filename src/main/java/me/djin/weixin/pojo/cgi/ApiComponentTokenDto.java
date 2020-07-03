/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public final class ApiComponentTokenDto {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;
	/**
	 * 第三方平台 appsecret
	 */
	private String component_appsecret;
	/**
	 * 微信后台推送的 ticket
	 * 
	 * ticket的获取可参考(https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/component_verify_ticket.html)
	 */
	private String component_verify_ticket;

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
	 * @return the component_appsecret
	 */
	public String getComponent_appsecret() {
		return component_appsecret;
	}

	/**
	 * @param component_appsecret the component_appsecret to set
	 */
	public void setComponent_appsecret(String component_appsecret) {
		this.component_appsecret = component_appsecret;
	}

	/**
	 * @return the component_verify_ticket
	 */
	public String getComponent_verify_ticket() {
		return component_verify_ticket;
	}

	/**
	 * @param component_verify_ticket the component_verify_ticket to set
	 */
	public void setComponent_verify_ticket(String component_verify_ticket) {
		this.component_verify_ticket = component_verify_ticket;
	}
}

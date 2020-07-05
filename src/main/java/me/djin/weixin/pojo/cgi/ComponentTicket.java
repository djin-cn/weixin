/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import java.sql.Date;

/**
 * 微信第三方ticket
 * 
 * 由微信每隔10分钟定时加密推送
 * 
 * 具体参考连接{@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/component_verify_ticket.html}
 * 
 * @author djin
 *
 */
public class ComponentTicket {
	/**
	 * 第三方平台 appid
	 */
	private String appId;
	/**
	 * 时间戳，单位：s
	 */
	private Date createTime;
	/**
	 * 固定为：component_verify_ticket
	 */
	private String infoType;
	/**
	 * Ticket 内容
	 */
	private String componentVerifyTicket;

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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the infoType
	 */
	public String getInfoType() {
		return infoType;
	}

	/**
	 * @param infoType the infoType to set
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	/**
	 * @return the componentVerifyTicket
	 */
	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	/**
	 * @param componentVerifyTicket the componentVerifyTicket to set
	 */
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

	@Override
	public String toString() {
		return "ComponentTicket [appId=" + appId + ", createTime=" + createTime + ", infoType=" + infoType
				+ ", componentVerifyTicket=" + componentVerifyTicket + "] " + super.toString();
	}
}

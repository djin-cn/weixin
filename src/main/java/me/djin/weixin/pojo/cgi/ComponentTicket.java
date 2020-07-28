/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import me.djin.weixin.util.Constant;
import me.djin.weixin.util.StringUtils;

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
public class ComponentTicket extends EventMessageModel {
	/**
	 * xml中ComponentVerifyTicket节点
	 */
	public static final String COMPONENTVERIFYTICKET_NODE = "ComponentVerifyTicket";
	/**
	 * Ticket 内容
	 */
	private String componentVerifyTicket;

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
		return "ComponentTicket [componentVerifyTicket="
				+ StringUtils.getMaskString(componentVerifyTicket, Constant.MASK_STRING) + "] " + super.toString();
	}
}

/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import me.djin.weixin.pojo.common.MpTemplateMsg;
import me.djin.weixin.pojo.common.WeappTemplateMsg;

/**
 * 服务消息发送模型
 * 
 * @author djin
 */
public class UniformMessageSendDto {
	/**
	 * 用户的openid, 发送给touser用户;<br/>
	 * 可以是小程序的openid，也可以是mp_template_msg.appid对应的公众号的openid
	 */
	private String touser;
	/**
	 * 小程序模板消息相关的信息, 有此实例对象则优先发送小程序模板消息, 即优先发送小程序消息
	 */
	private WeappTemplateMsg weapp_template_msg;
	/**
	 * 公众号模板消息相关的信息，有此实例对象并且没有weapp_template_msg实例时，发送公众号模板消息, 即优先发送小程序消息
	 */
	private MpTemplateMsg mp_template_msg;

	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}

	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	/**
	 * @return the weapp_template_msg
	 */
	public WeappTemplateMsg getWeapp_template_msg() {
		return weapp_template_msg;
	}

	/**
	 * @param weapp_template_msg the weapp_template_msg to set
	 */
	public void setWeapp_template_msg(WeappTemplateMsg weapp_template_msg) {
		this.weapp_template_msg = weapp_template_msg;
	}

	/**
	 * @return the mp_template_msg
	 */
	public MpTemplateMsg getMp_template_msg() {
		return mp_template_msg;
	}

	/**
	 * @param mp_template_msg the mp_template_msg to set
	 */
	public void setMp_template_msg(MpTemplateMsg mp_template_msg) {
		this.mp_template_msg = mp_template_msg;
	}
}

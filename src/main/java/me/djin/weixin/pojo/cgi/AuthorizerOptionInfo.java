/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * 授权方选项信息
 * 
 * @author djin
 *
 */
public class AuthorizerOptionInfo {
	/**
	 * 授权公众号或小程序的 appid
	 */
	private String authorizer_appid;
	/**
	 * 选项名称
	 */
	private String option_name;
	/**
	 * 选项值
	 * 
	 * location_report 地理位置上报选项 {0:无上报, 1: 进入会话时上报, 2: 每 5s上报}
	 * 
	 * voice_recognize 语音识别开关选项 {0:关闭语音识别, 1: 开启语音识别}
	 * 
	 * customer_service 多客服开关选项{0:关闭多客服, 1:开启多客服}
	 */
	private String option_value;

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
	 * @return the option_name
	 */
	public String getOption_name() {
		return option_name;
	}

	/**
	 * @param option_name the option_name to set
	 */
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

	/**
	 * @return the option_value
	 */
	public String getOption_value() {
		return option_value;
	}

	/**
	 * @param option_value the option_value to set
	 */
	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}

	@Override
	public String toString() {
		return "AuthorizerOptionInfo [authorizer_appid=" + authorizer_appid + ", option_name=" + option_name
				+ ", option_value=" + option_value + "] " + super.toString();
	}
}

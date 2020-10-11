/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiGetAuthorizerOptionDto {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;
	/**
	 * 授权公众号或小程序的 appid
	 */
	private String authorizer_appid;
	/**
	 * 选项名称
	 * 
	 * location_report: 地理位置上报选项
	 * 
	 * voice_recognize: 语音识别开关选项
	 * 
	 * customer_service: 多客服开关选项
	 */
	private String option_name;

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

	@Override
	public String toString() {
		return "ApiGetAuthorizerOptionDto [component_appid=" + component_appid + ", authorizer_appid="
				+ authorizer_appid + ", option_name=" + option_name + "] " + super.toString();
	}
}

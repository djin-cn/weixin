/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiQueryAuthDto {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;
	/**
	 * 授权码, 会在授权成功时返回给第三方平台
	 * 
	 * 第三方平台授权流程参考{@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Authorization_Process_Technical_Description.html}
	 */
	private String authorization_code;

	@Override
	public String toString() {
		return "ApiQueryAuthDto [component_appid=" + component_appid + ", authorization_code=" + authorization_code
				+ "] " + super.toString();
	}

}

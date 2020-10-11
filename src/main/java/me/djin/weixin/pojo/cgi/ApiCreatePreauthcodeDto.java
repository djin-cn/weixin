/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiCreatePreauthcodeDto {
	/**
	 * 第三方平台 appid
	 */
	private String component_appid;

	@Override
	public String toString() {
		return "ApiCreatePreauthcodeDto [component_appid=" + component_appid + "] " + super.toString();
	}
}

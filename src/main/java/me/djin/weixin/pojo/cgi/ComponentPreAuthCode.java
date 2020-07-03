/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * 第三方平台预授权吗
 * 
 * @author djin
 */
public class ComponentPreAuthCode {
	/**
	 * 预授权码
	 */
	private String pre_auth_code;
	/**
	 * 有效期，单位：秒
	 */
	private String expires_in;

	@Override
	public String toString() {
		return "ComponentPreAuthCode [pre_auth_code=" + pre_auth_code + ", expires_in=" + expires_in + "] "
				+ super.toString();
	}
}

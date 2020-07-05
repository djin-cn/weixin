/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * 微信开放平台第三方平台的令牌
 * 
 * @author djin
 */
public final class ComponentToken {
	/**
	 * 第三方平台 access_token
	 */
	private String component_access_token;
	/**
	 * 有效期，单位：秒
	 */
	private Integer expires_in;

	/**
	 * @return the component_access_token
	 */
	public String getComponent_access_token() {
		return component_access_token;
	}

	/**
	 * @param component_access_token the component_access_token to set
	 */
	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	/**
	 * @return the expires_in
	 */
	public Integer getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "ComponentToken [component_access_token=" + component_access_token + ", expires_in=" + expires_in + "] "
				+ super.toString();
	}
}

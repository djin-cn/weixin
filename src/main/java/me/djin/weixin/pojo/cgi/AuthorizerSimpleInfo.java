/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * 授权账号简单信息
 * 
 * @author djin
 */
public class AuthorizerSimpleInfo {
	/**
	 * 已授权的 appid
	 */
	private String authorizer_appid;
	/**
	 * 刷新令牌
	 */
	private String refresh_token;
	/**
	 * 授权的时间
	 */
	private Integer auth_time;

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
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * @param refresh_token the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * @return the auth_time
	 */
	public Integer getAuth_time() {
		return auth_time;
	}

	/**
	 * @param auth_time the auth_time to set
	 */
	public void setAuth_time(Integer auth_time) {
		this.auth_time = auth_time;
	}

	@Override
	public String toString() {
		return "AuthorizerSimpleInfo [authorizer_appid=" + authorizer_appid + ", refresh_token=" + refresh_token
				+ ", auth_time=" + auth_time + "] " + super.toString();
	}
}

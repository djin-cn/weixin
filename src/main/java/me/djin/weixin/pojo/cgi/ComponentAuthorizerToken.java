package me.djin.weixin.pojo.cgi;

/**
 * 小程序/公众号授权给第三方的授权令牌
 * 
 * 在公众号/小程序接口调用令牌（authorizer_access_token）失效时，可以使用刷新令牌（authorizer_refresh_token）获取新的接口调用令牌。
 * 
 * 注意： authorizer_access_token 有效期为 2 小时，开发者需要缓存
 * authorizer_access_token，避免获取/刷新接口调用令牌的 API 调用触发每日限额.
 * 
 * @author djin
 *
 */
public class ComponentAuthorizerToken {
	/**
	 * 公众号/小程序/授权方令牌
	 */
	private String authorizer_access_token;
	/**
	 * 有效期，单位：秒
	 */
	private String expires_in;
	/**
	 * 刷新令牌
	 */
	private String authorizer_refresh_token;

	/**
	 * @return the authorizer_access_token
	 */
	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}

	/**
	 * @param authorizer_access_token the authorizer_access_token to set
	 */
	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}

	/**
	 * @return the expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the authorizer_refresh_token
	 */
	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}

	/**
	 * @param authorizer_refresh_token the authorizer_refresh_token to set
	 */
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}

	@Override
	public String toString() {
		return "ComponentAuthorizerToken [authorizer_access_token=" + authorizer_access_token + ", expires_in="
				+ expires_in + ", authorizer_refresh_token=" + authorizer_refresh_token + "] " + super.toString();
	}
}

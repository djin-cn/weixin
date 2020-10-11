/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import java.util.List;

import me.djin.weixin.util.CollectionUtils;
import me.djin.weixin.util.Constant;

/**
 * 第三方授权信息
 * 
 * 具体权限集可参考连接{@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/func_info.html}
 * 
 * @author djin
 */
public class ComponentApiAuth {
	/**
	 * 授权信息
	 */
	private AuthorizationInfo authorization_info;

	/**
	 * @return the authorization_info
	 */
	public AuthorizationInfo getAuthorization_info() {
		return authorization_info;
	}

	/**
	 * @param authorization_info the authorization_info to set
	 */
	public void setAuthorization_info(AuthorizationInfo authorization_info) {
		this.authorization_info = authorization_info;
	}

	@Override
	public String toString() {
		return "ComponentApiAuth [authorization_info=" + authorization_info + "] " + super.toString();
	}

	public static class AuthorizationInfo {
		/**
		 * 授权方 appid
		 */
		private String authorizer_appid;
		/**
		 * 接口调用令牌（在授权的公众号/小程序具备 API 权限时，才有此返回值）
		 */
		private String authorizer_access_token;
		/**
		 * authorizer_access_token 的有效期（在授权的公众号/小程序具备API权限时，才有此返回值），单位：秒
		 */
		private Integer expires_in;
		/**
		 * 刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于第三方平台获取和刷新已授权用户的
		 * authorizer_access_token。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌。用户重新授权后，之前的刷新令牌会失效
		 */
		private String authorizer_refresh_token;
		/**
		 * 授权给开发者的权限集列表
		 */
		private List<FunctionInfo> func_info;

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
		public Integer getExpires_in() {
			return expires_in;
		}

		/**
		 * @param expires_in the expires_in to set
		 */
		public void setExpires_in(Integer expires_in) {
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

		/**
		 * @return the func_info
		 */
		public List<FunctionInfo> getFunc_info() {
			return func_info;
		}

		/**
		 * @param func_info the func_info to set
		 */
		public void setFunc_info(List<FunctionInfo> func_info) {
			this.func_info = func_info;
		}

		@Override
		public String toString() {
			return "AuthorizationInfo [authorizer_appid=" + authorizer_appid + ", authorizer_access_token="
					+ authorizer_access_token + ", expires_in=" + expires_in + ", authorizer_refresh_token="
					+ authorizer_refresh_token + ", func_info="
					+ CollectionUtils.toString(func_info, Constant.SEPARATOR) + "] " + super.toString();

		}
	}

}

/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import java.util.List;

import me.djin.weixin.util.CollectionUtils;
import me.djin.weixin.util.Constant;

/**
 * 公众号/小程序/授权方信息
 * 
 * @author djin
 *
 */
public class AuthorizerInfo {
	/**
	 * 授权信息
	 */
	private AuthorizationInfo authorization_info;
	/**
	 * 账号信息
	 */
	private AccountInfo authorizer_info;

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

	/**
	 * @return the authorizer_info
	 */
	public AccountInfo getAuthorizer_info() {
		return authorizer_info;
	}

	/**
	 * @param authorizer_info the authorizer_info to set
	 */
	public void setAuthorizer_info(AccountInfo authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	@Override
	public String toString() {
		return "AuthorizerInfo [authorization_info=" + authorization_info + ", authorizer_info=" + authorizer_info
				+ "] " + super.toString();
	}

	/**
	 * 账号信息
	 * 
	 * @author djin
	 *
	 */
	public static class AccountInfo {
		/**
		 * 昵称
		 */
		private String nick_name;
		/**
		 * 头像
		 */
		private String head_img;
		/**
		 * 公众号类型, 小程序默认为0
		 */
		private ServiceType service_type_info;
		/**
		 * 公众号/小程序认证类型
		 */
		private VerifyType verify_type_info;
		/**
		 * 原始ID
		 */
		private String user_name;
		/**
		 * 主体名称
		 */
		private String principal_name;
		/**
		 * 公众号所设置的微信号，可能为空; 公众号特有, 小程序么有的
		 */
		private String alias;
		/**
		 * 账号介绍; 小程序特有, 公众号没有的
		 */
		private String signature;
		/**
		 * 用以了解功能的开通状况（0代表未开通，1代表已开通）
		 */
		private BusinessInfo business_info;
		/**
		 * 二维码图片的 URL，开发者最好自行也进行保存
		 */
		private String qrcode_url;
		/**
		 * 小程序配置, 根据这个字段判断是否为小程序类型授权; 公众号是没有的
		 */
		private MiniProgramInfoConfig miniprograminfo;

		@Override
		public String toString() {
			return "AccountInfo [nick_name=" + nick_name + ", head_img=" + head_img + ", service_type_info="
					+ service_type_info + ", verify_type_info=" + verify_type_info + ", user_name=" + user_name
					+ ", principal_name=" + principal_name + ", alias=" + alias + ", signature=" + signature
					+ ", business_info=" + business_info + ", qrcode_url=" + qrcode_url + ", miniprograminfo="
					+ miniprograminfo + "] " + super.toString();
		}

		/**
		 * @return the nick_name
		 */
		public String getNick_name() {
			return nick_name;
		}

		/**
		 * @param nick_name the nick_name to set
		 */
		public void setNick_name(String nick_name) {
			this.nick_name = nick_name;
		}

		/**
		 * @return the head_img
		 */
		public String getHead_img() {
			return head_img;
		}

		/**
		 * @param head_img the head_img to set
		 */
		public void setHead_img(String head_img) {
			this.head_img = head_img;
		}

		/**
		 * @return the service_type_info
		 */
		public ServiceType getService_type_info() {
			return service_type_info;
		}

		/**
		 * @param service_type_info the service_type_info to set
		 */
		public void setService_type_info(ServiceType service_type_info) {
			this.service_type_info = service_type_info;
		}

		/**
		 * @return the verify_type_info
		 */
		public VerifyType getVerify_type_info() {
			return verify_type_info;
		}

		/**
		 * @param verify_type_info the verify_type_info to set
		 */
		public void setVerify_type_info(VerifyType verify_type_info) {
			this.verify_type_info = verify_type_info;
		}

		/**
		 * @return the user_name
		 */
		public String getUser_name() {
			return user_name;
		}

		/**
		 * @param user_name the user_name to set
		 */
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		/**
		 * @return the principal_name
		 */
		public String getPrincipal_name() {
			return principal_name;
		}

		/**
		 * @param principal_name the principal_name to set
		 */
		public void setPrincipal_name(String principal_name) {
			this.principal_name = principal_name;
		}

		/**
		 * @return the alias
		 */
		public String getAlias() {
			return alias;
		}

		/**
		 * @param alias the alias to set
		 */
		public void setAlias(String alias) {
			this.alias = alias;
		}

		/**
		 * @return the signature
		 */
		public String getSignature() {
			return signature;
		}

		/**
		 * @param signature the signature to set
		 */
		public void setSignature(String signature) {
			this.signature = signature;
		}

		/**
		 * @return the business_info
		 */
		public BusinessInfo getBusiness_info() {
			return business_info;
		}

		/**
		 * @param business_info the business_info to set
		 */
		public void setBusiness_info(BusinessInfo business_info) {
			this.business_info = business_info;
		}

		/**
		 * @return the qrcode_url
		 */
		public String getQrcode_url() {
			return qrcode_url;
		}

		/**
		 * @param qrcode_url the qrcode_url to set
		 */
		public void setQrcode_url(String qrcode_url) {
			this.qrcode_url = qrcode_url;
		}

		/**
		 * @return the miniprograminfo
		 */
		public MiniProgramInfoConfig getMiniprograminfo() {
			return miniprograminfo;
		}

		/**
		 * @param miniprograminfo the miniprograminfo to set
		 */
		public void setMiniprograminfo(MiniProgramInfoConfig miniprograminfo) {
			this.miniprograminfo = miniprograminfo;
		}

		/**
		 * 公众号类型, 如果是小程序则默认为0; 即无法就此判断是小程序还是公众号
		 * 
		 * 0: 订阅号
		 * 
		 * 1: 由历史老帐号升级后的订阅号
		 * 
		 * 2: 服务号
		 * 
		 * @author djin
		 *
		 */
		public static class ServiceType {
			/**
			 * 公众号类型, 如果是小程序则默认为0; 即无法就此判断是小程序还是公众号
			 * 
			 * 0: 订阅号
			 * 
			 * 1: 由历史老帐号升级后的订阅号
			 * 
			 * 2: 服务号
			 */
			private String id;

			@Override
			public String toString() {
				return "ServiceType [id=" + id + "] " + super.toString();
			}

			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(String id) {
				this.id = id;
			}

		}

		/**
		 * 认证类型; 小程序只有以下类型的-1和0, 不存在其他认证类型;
		 * 
		 * -1: 未认证
		 * 
		 * 0: 微信认证
		 * 
		 * 1: 新浪微博认证
		 * 
		 * 2: 腾讯微博认证
		 * 
		 * 3: 已资质认证通过但还未通过名称认证
		 * 
		 * 4: 已资质认证通过、还未通过名称认证，但通过了新浪微博认证
		 * 
		 * 5: 已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
		 * 
		 * @author djin
		 *
		 */
		public static class VerifyType {
			/**
			 * 认证类型; 小程序只有以下类型的-1和0, 不存在其他认证类型;
			 * 
			 * -1: 未认证
			 * 
			 * 0: 微信认证
			 * 
			 * 1: 新浪微博认证
			 * 
			 * 2: 腾讯微博认证
			 * 
			 * 3: 已资质认证通过但还未通过名称认证
			 * 
			 * 4: 已资质认证通过、还未通过名称认证，但通过了新浪微博认证
			 * 
			 * 5: 已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
			 */
			private String id;

			@Override
			public String toString() {
				return "VerifyType [id=" + id + "] " + super.toString();
			}

			/**
			 * @return the id
			 */
			public String getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(String id) {
				this.id = id;
			}
		}

		/**
		 * 功能开通信息（0代表未开通，1代表已开通）
		 * 
		 * @author djin
		 *
		 */
		public static class BusinessInfo {
			/**
			 * 是否开通微信门店功能
			 */
			private String open_store;
			/**
			 * 是否开通微信扫商品功能
			 */
			private String open_scan;
			/**
			 * 是否开通微信支付功能
			 */
			private String open_pay;
			/**
			 * 是否开通微信卡券功能
			 */
			private String open_card;
			/**
			 * 是否开通微信摇一摇功能
			 */
			private String open_shake;

			/**
			 * @return the open_store
			 */
			public String getOpen_store() {
				return open_store;
			}

			/**
			 * @param open_store the open_store to set
			 */
			public void setOpen_store(String open_store) {
				this.open_store = open_store;
			}

			/**
			 * @return the open_scan
			 */
			public String getOpen_scan() {
				return open_scan;
			}

			/**
			 * @param open_scan the open_scan to set
			 */
			public void setOpen_scan(String open_scan) {
				this.open_scan = open_scan;
			}

			/**
			 * @return the open_pay
			 */
			public String getOpen_pay() {
				return open_pay;
			}

			/**
			 * @param open_pay the open_pay to set
			 */
			public void setOpen_pay(String open_pay) {
				this.open_pay = open_pay;
			}

			/**
			 * @return the open_card
			 */
			public String getOpen_card() {
				return open_card;
			}

			/**
			 * @param open_card the open_card to set
			 */
			public void setOpen_card(String open_card) {
				this.open_card = open_card;
			}

			/**
			 * @return the open_shake
			 */
			public String getOpen_shake() {
				return open_shake;
			}

			/**
			 * @param open_shake the open_shake to set
			 */
			public void setOpen_shake(String open_shake) {
				this.open_shake = open_shake;
			}

			@Override
			public String toString() {
				return "BusinessInfo [open_store=" + open_store + ", open_scan=" + open_scan + ", open_pay=" + open_pay
						+ ", open_card=" + open_card + ", open_shake=" + open_shake + "] " + super.toString();
			}
		}

		/**
		 * 小程序配置信息
		 * 
		 * @author djin
		 *
		 */
		public static class MiniProgramInfoConfig {
			/**
			 * 小程序配置的合法域名信息
			 */
			private Network network;
			/**
			 * 小程序配置的类目信息
			 */
			private List<Category> categories;

			/**
			 * @return the network
			 */
			public Network getNetwork() {
				return network;
			}

			/**
			 * @param network the network to set
			 */
			public void setNetwork(Network network) {
				this.network = network;
			}

			/**
			 * @return the categories
			 */
			public List<Category> getCategories() {
				return categories;
			}

			/**
			 * @param categories the categories to set
			 */
			public void setCategories(List<Category> categories) {
				this.categories = categories;
			}

			@Override
			public String toString() {
				return "MiniProgramInfoConfig [network=" + network + ", categories="
						+ CollectionUtils.toString(categories, Constant.SEPARATOR) + "] " + super.toString();
			}
		}

		/**
		 * 小程序配置的合法域名信息
		 * 
		 * @author djin
		 *
		 */
		public static class Network {
			/**
			 * 请求域名
			 */
			private List<String> RequestDomain;
			/**
			 * websocket域名
			 */
			private List<String> WsRequestDomain;
			/**
			 * 上传域名
			 */
			private List<String> UploadDomain;
			/**
			 * 下载域名
			 */
			private List<String> DownloadDomain;

			/**
			 * @return the requestDomain
			 */
			public List<String> getRequestDomain() {
				return RequestDomain;
			}

			/**
			 * @param requestDomain the requestDomain to set
			 */
			public void setRequestDomain(List<String> requestDomain) {
				RequestDomain = requestDomain;
			}

			/**
			 * @return the wsRequestDomain
			 */
			public List<String> getWsRequestDomain() {
				return WsRequestDomain;
			}

			/**
			 * @param wsRequestDomain the wsRequestDomain to set
			 */
			public void setWsRequestDomain(List<String> wsRequestDomain) {
				WsRequestDomain = wsRequestDomain;
			}

			/**
			 * @return the uploadDomain
			 */
			public List<String> getUploadDomain() {
				return UploadDomain;
			}

			/**
			 * @param uploadDomain the uploadDomain to set
			 */
			public void setUploadDomain(List<String> uploadDomain) {
				UploadDomain = uploadDomain;
			}

			/**
			 * @return the downloadDomain
			 */
			public List<String> getDownloadDomain() {
				return DownloadDomain;
			}

			/**
			 * @param downloadDomain the downloadDomain to set
			 */
			public void setDownloadDomain(List<String> downloadDomain) {
				DownloadDomain = downloadDomain;
			}

			@Override
			public String toString() {
				return "Network [RequestDomain=" + CollectionUtils.toString(RequestDomain, Constant.SEPARATOR)
						+ ", WsRequestDomain=" + CollectionUtils.toString(WsRequestDomain, Constant.SEPARATOR)
						+ ", UploadDomain=" + CollectionUtils.toString(UploadDomain, Constant.SEPARATOR)
						+ ", DownloadDomain=" + CollectionUtils.toString(DownloadDomain, Constant.SEPARATOR) + "] "
						+ super.toString();
			}
		}

		/**
		 * 小程序配置的的类目信息
		 * 
		 * @author djin
		 *
		 */
		public static class Category {
			/**
			 * 一级类目
			 */
			private String first;
			/**
			 * 二级类目
			 */
			private String second;

			/**
			 * @return the first
			 */
			public String getFirst() {
				return first;
			}

			/**
			 * @param first the first to set
			 */
			public void setFirst(String first) {
				this.first = first;
			}

			/**
			 * @return the second
			 */
			public String getSecond() {
				return second;
			}

			/**
			 * @param second the second to set
			 */
			public void setSecond(String second) {
				this.second = second;
			}

			@Override
			public String toString() {
				return "Category [first=" + first + ", second=" + second + "] " + super.toString();
			}
		}
	}

	/**
	 * 授权信息
	 * 
	 * @author djin
	 *
	 */
	public static class AuthorizationInfo {
		/**
		 * 授权方 appid
		 */
		private String authorization_appid;
		/**
		 * 授权给开发者的权限集列表
		 */
		private List<FunctionInfo> func_info;

		/**
		 * @return the authorization_appid
		 */
		public String getAuthorization_appid() {
			return authorization_appid;
		}

		/**
		 * @param authorization_appid the authorization_appid to set
		 */
		public void setAuthorization_appid(String authorization_appid) {
			this.authorization_appid = authorization_appid;
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
			return "AuthorizationInfo [authorization_appid=" + authorization_appid + ", func_info=" + func_info + "] "
					+ super.toString();
		}
	}
}

/**
 * 
 */
package me.djin.weixin.api;

import feign.Param;
import feign.RequestLine;
import me.djin.weixin.pojo.BaseModel;
import me.djin.weixin.pojo.cgi.ApiAuthorizerTokenDto;
import me.djin.weixin.pojo.cgi.ApiComponentTokenDto;
import me.djin.weixin.pojo.cgi.ApiCreatePreauthcodeDto;
import me.djin.weixin.pojo.cgi.ApiGetAuthorizerInfoDto;
import me.djin.weixin.pojo.cgi.ApiGetAuthorizerListDto;
import me.djin.weixin.pojo.cgi.ApiGetAuthorizerOptionDto;
import me.djin.weixin.pojo.cgi.ApiQueryAuthDto;
import me.djin.weixin.pojo.cgi.ApiSetAuthorizerOptionDto;
import me.djin.weixin.pojo.cgi.AuthorizerInfo;
import me.djin.weixin.pojo.cgi.AuthorizerOptionInfo;
import me.djin.weixin.pojo.cgi.AuthorizerSimpleInfo;
import me.djin.weixin.pojo.cgi.ComponentApiAuth;
import me.djin.weixin.pojo.cgi.ComponentAuthorizerToken;
import me.djin.weixin.pojo.cgi.ComponentPreAuthCode;
import me.djin.weixin.pojo.cgi.ComponentToken;
import me.djin.weixin.pojo.cgi.Page;

/**
 * 微信网关类接口
 * 
 * @author djin
 */
public interface Cgi {
	/**
	 * 令牌（component_access_token）是第三方平台接口的调用凭据。
	 * 
	 * 如未特殊说明，令牌一般作为被调用接口的 GET 参数 component_access_token 的值使用
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/component_access_token.html}
	 * 
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_component_token")
	ComponentToken apiComponentToken(ApiComponentTokenDto dto);

	/**
	 * 获取预授权码
	 * 
	 * 预授权码是第三方平台方实现授权托管的必备信息，每个预授权码有效期为 10 分钟。
	 * 
	 * 需要先获取令牌才能调用
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/pre_auth_code.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_create_preauthcode?component_access_token={component_access_token}")
	ComponentPreAuthCode apiCreatePreauthcode(@Param("component_access_token") String componentAccessToken,
			ApiCreatePreauthcodeDto dto);

	/**
	 * 获取授权信息
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/authorization_info.html}
	 * 
	 * 权限集参考
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/func_info.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_query_auth?component_access_token={component_access_token}")
	ComponentApiAuth apiQueryAuth(@Param("component_access_token") String componentAccessToken, ApiQueryAuthDto dto);

	/**
	 * 获取/刷新接口调用令牌
	 * 
	 * 在公众号/小程序接口调用令牌（authorizer_access_token）失效时，可以使用刷新令牌（authorizer_refresh_token）获取新的接口调用令牌。
	 * 
	 * 注意： authorizer_access_token 有效期为 2 小时，开发者需要缓存
	 * authorizer_access_token，避免获取/刷新接口调用令牌的 API 调用触发每日限额
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_authorizer_token.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_authorizer_token?component_access_token={component_access_token}")
	ComponentAuthorizerToken apiAuthorizerToken(@Param("component_access_token") String componentAccessToken,
			ApiAuthorizerTokenDto dto);

	/**
	 * 获取授权方的帐号基本信息
	 * 
	 * 该 API 用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
	 * 
	 * 注意： 公众号和小程序的接口返回结果不一样
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_get_authorizer_info.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_get_authorizer_info?component_access_token={component_access_token}")
	AuthorizerInfo apiGetAuthorizerInfo(@Param("component_access_token") String componentAccessToken,
			ApiGetAuthorizerInfoDto dto);

	/**
	 * 获取授权方选项信息
	 * 
	 * 本 API 用于获取授权方的公众号/小程序的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_get_authorizer_option.html}
	 * 
	 * 注意：
	 * 获取各项选项设置信息，需要有授权方的授权，详见权限集说明。{@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/func_info.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_get_authorizer_option?component_access_token={component_access_token}")
	AuthorizerOptionInfo apiGetAuthorizerOption(@Param("component_access_token") String componentAccessToken,
			ApiGetAuthorizerOptionDto dto);

	/**
	 * 设置授权方选项信息
	 * 
	 * 本 API 用于设置授权方的公众号/小程序的选项信息，如：地理位置上报，语音识别开关，多客服开关。
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_set_authorizer_option.html}
	 * 
	 * 注意：
	 * 设置各项选项设置信息，需要有授权方的授权，详见权限集说明。{@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/func_info.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_set_authorizer_option?component_access_token={component_access_token}")
	BaseModel apiSetAuthorizerOption(@Param("component_access_token") String componentAccessToken,
			ApiSetAuthorizerOptionDto dto);

	/**
	 * 拉取当前所有已授权的帐号基本信息
	 * 
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_get_authorizer_list.html}
	 * 
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @param dto
	 * @return
	 */
	@RequestLine("POST /cgi-bin/component/api_get_authorizer_list?component_access_token={component_access_token}")
	Page<AuthorizerSimpleInfo> apiGetAuthorizerList(@Param("component_access_token") String componentAccessToken,
			ApiGetAuthorizerListDto dto);
}

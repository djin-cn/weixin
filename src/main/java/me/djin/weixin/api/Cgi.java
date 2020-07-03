/**
 * 
 */
package me.djin.weixin.api;

import feign.Param;
import feign.RequestLine;
import me.djin.weixin.pojo.cgi.ApiComponentTokenDto;
import me.djin.weixin.pojo.cgi.ApiCreatePreauthcodeDto;
import me.djin.weixin.pojo.cgi.ComponentPreAuthCode;
import me.djin.weixin.pojo.cgi.ComponentToken;

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

}

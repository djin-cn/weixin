/**
 * 
 */
package me.djin.weixin.api;

import feign.Param;
import feign.RequestLine;
import me.djin.weixin.pojo.cgi.ApiComponentTokenDto;
import me.djin.weixin.pojo.sns.AccessToken;
import me.djin.weixin.pojo.sns.SessionToken;

/**
 * @author djin 微信基础接口
 */
public interface Sns {
	/**
	 * 获取用户访问令牌<br/>
	 * 
	 * 适用于网页登录场景, 如: 公众号登录/第三方平台网站登录
	 * 
	 * @param appid     appid,如果是可登录微信公众号平台, 在“开发”-“基本配置”-“开发者ID”获取; 如果是微信开放平台,
	 *                  在微信开放平台提交应用审核通过后获得
	 * @param appsecret appsecret,如果是可登录微信公众号平台, 可登录微信公众号平台，在“开发”-“基本配置”-“开发者密码”获取;
	 *                  如果是微信开放平台, 在微信开放平台提交应用审核通过后获得
	 * @param code      可参考微信网页授权的第一步“用户同意授权，获取code”获取.<br>
	 *                  第一步可通过网页获取，但是需要设置网页授权回调域名(需认证).<br>
	 *                  网址：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
	 * @return
	 */
	@RequestLine("GET /sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type=authorization_code")
	AccessToken accessToken(@Param("appid") String appid, @Param("secret") String appsecret,
			@Param("code") String code);

	/**
	 * 登录凭证校验。通过 wx.login接口获得临时登录凭证 code后传到开发者服务器调用此接口完成登录流程.<br/>
	 * 适用于小程序登录场景
	 * 
	 * @param appid     小程序 appId
	 * @param appsecret 小程序 appSecret
	 * @param code      code 登录时获取的 code
	 * @return
	 */
	@RequestLine("GET /sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code")
	SessionToken jsCode2Session(@Param("appid") String appid, @Param("secret") String appsecret,
			@Param("code") String code);

	/**
	 * 第三方平台服务器使用登录凭证code和第三方平台的 component_access_token代替小程序实现登录功能获取 session_key和
	 * openid。<br/>
	 * 其中 session_key 是对用户数据进行加密签名的密钥。为了自身应用安全，session_key 不应该在网络上传输。<br/>
	 * 
	 * 适用于第三方平台代小程序实现登录场景
	 * 
	 * @param appid                小程序 appId
	 * @param jsCode               wx.login获取的code
	 * @param componentAppId       第三方平台 appid
	 * @param componentAccessToken 令牌
	 *                             {@link Cgi#apiComponentToken(ApiComponentTokenDto)}
	 * @return
	 */
	@RequestLine("GET /sns/component/jscode2session?appid={appid}&js_code={code}&grant_type=authorization_code&component_appid={component_appid}&component_access_token={component_access_token}")
	SessionToken jsCode2SessionByComponentToken(@Param("appid") String appid, @Param("code") String jsCode,
			@Param("component_appid") String componentAppId,
			@Param("component_access_token") String componentAccessToken);
}

/**
 * 
 */
package me.djin.weixin.pojo.basesns;

import me.djin.weixin.pojo.BaseModel;

/**
 * @author djin
 */
public class JsCode2SessionResponse extends BaseModel {
	private String openid;
	private String session_key;
	private String unionid;

	/**
	 * @return 用户唯一标识
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid 用户唯一标识
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return 会话密钥
	 */
	public String getSession_key() {
		return session_key;
	}

	/**
	 * @param session_key 会话密钥
	 */
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	/**
	 * unionid参考https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/union-id.html
	 * 
	 * @return 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * unionid参考https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/union-id.html
	 * 
	 * @param unionid 用户在开放平台的唯一标识符
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}

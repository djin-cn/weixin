package me.djin.weixin.pojo.common;

/**
 * 事件类型
 * 
 * 参考
 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/authorize_event.html#infotype-%E8%AF%B4%E6%98%8E}
 * 
 * @author djin
 *
 */
public enum EventType {
	/**
	 * 验证票据
	 */
	COMPONENT_VERIFY_TICKET,
	/**
	 * 取消授权
	 */
	UNAUTHORIZED,
	/**
	 * 更新授权
	 */
	UPDATEAUTHORIZED,
	/**
	 * 授权成功
	 */
	AUTHORIZED
}
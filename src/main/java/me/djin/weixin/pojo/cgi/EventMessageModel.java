package me.djin.weixin.pojo.cgi;

import java.util.Date;

import me.djin.weixin.pojo.common.EventType;

/**
 * 事件消息模型, 包含多种事件消息, 具体类型参考{@link EventType}
 * 
 * @author djin
 *
 */
public class EventMessageModel {
	/**
	 * xml中AppId节点
	 */
	public static final String APPID_NODE = "AppId";
	/**
	 * xml中CreateTime节点
	 */
	public static final String CREATETIME_NODE = "CreateTime";
	/**
	 * xml中InfoType节点
	 */
	public static final String INFOTYPE_NODE = "InfoType";
	/**
	 * 第三方平台 appid
	 */
	private String appId;
	/**
	 * 时间戳，单位：秒
	 */
	private Date createTime;
	/**
	 * 事件类型
	 */
	private EventType infoType;

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the infoType
	 */
	public EventType getInfoType() {
		return infoType;
	}

	/**
	 * @param infoType the infoType to set
	 */
	public void setInfoType(EventType infoType) {
		this.infoType = infoType;
	}

	@Override
	public String toString() {
		return "EventMessageModel [appId=" + appId + ", createTime=" + createTime + ", infoType=" + infoType + "] "
				+ super.toString();
	}
}
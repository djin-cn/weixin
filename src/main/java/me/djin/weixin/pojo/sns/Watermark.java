/**
 * 
 */
package me.djin.weixin.pojo.sns;

/**
 * 数据水印
 * 
 * @author djin
 *
 */
public class Watermark {
	/**
	 * appid
	 */
	private String appid;
	/**
	 * 时间戳
	 */
	private String timestamp;

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Watermark [appid=" + appid + ", timestamp=" + timestamp + "] " + super.toString();
	}
}

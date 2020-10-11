/**
 * 
 */
package me.djin.weixin.pojo.cgi;

/**
 * @author djin
 *
 */
public class ApiGetAuthorizerListDto {
	/**
	 * 第三方平台 APPID
	 */
	private String component_appid;
	/**
	 * 偏移位置/起始位置
	 */
	private String offset;
	/**
	 * 拉取数量，最大为 500
	 */
	private String count;

	/**
	 * @return the component_appid
	 */
	public String getComponent_appid() {
		return component_appid;
	}

	/**
	 * @param component_appid the component_appid to set
	 */
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

	/**
	 * @return the offset
	 */
	public String getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ApiGetAuthorizerListDto [component_appid=" + component_appid + ", offset=" + offset + ", count=" + count
				+ "] " + super.toString();
	}
}

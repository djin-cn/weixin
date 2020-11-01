/**
 * 
 */
package me.djin.weixin.pojo.common;

/**
 * 公众号消息模板
 * 
 * @author djin
 *
 */
public class MpTemplateMsg {
	/**
	 * 公众号appid，要求与小程序有绑定且同主体
	 */
	private String appid;
	/**
	 * 公众号模板id
	 */
	private String template_id;
	/**
	 * 公众号模板消息所要跳转的url
	 */
	private String url;
	/**
	 * 公众号模板消息所要跳转的小程序，小程序的必须与公众号具有绑定关系
	 */
	private String miniprogram;
	/**
	 * 公众号模板消息的数据
	 */
	private String data;

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
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the miniprogram
	 */
	public String getMiniprogram() {
		return miniprogram;
	}

	/**
	 * @param miniprogram the miniprogram to set
	 */
	public void setMiniprogram(String miniprogram) {
		this.miniprogram = miniprogram;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
}

/**
 * 
 */
package me.djin.weixin.pojo.common;

/**
 * 微信小程序消息模板
 * 
 * @author djin
 */
public class WeappTemplateMsg {
	/**
	 * 小程序模板ID
	 */
	private String template_id;
	/**
	 * 小程序页面路径
	 */
	private String page;
	/**
	 * 小程序模板消息formid
	 */
	private String form_id;
	/**
	 * 小程序模板数据
	 */
	private String data;
	/**
	 * 小程序模板放大关键词
	 */
	private String emphasis_keyword;

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
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the form_id
	 */
	public String getForm_id() {
		return form_id;
	}

	/**
	 * @param form_id the form_id to set
	 */
	public void setForm_id(String form_id) {
		this.form_id = form_id;
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

	/**
	 * @return the emphasis_keyword
	 */
	public String getEmphasis_keyword() {
		return emphasis_keyword;
	}

	/**
	 * @param emphasis_keyword the emphasis_keyword to set
	 */
	public void setEmphasis_keyword(String emphasis_keyword) {
		this.emphasis_keyword = emphasis_keyword;
	}
}

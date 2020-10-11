/**
 * 
 */
package me.djin.weixin.pojo;

/**
 * @author djin 所有微信返回值的基础对象
 */
public class BaseModel {
	private Integer errcode;
	private String errmsg;

	/**
	 * 获取错误码
	 * 
	 * -1: 系统繁忙，此时请开发者稍候再试
	 * 
	 * 0: 请求成功
	 * 
	 * 40029: code 无效
	 * 
	 * 45011: 频率限制，每个用户每分钟100次
	 * 
	 * @return 错误码
	 */
	public Integer getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode 错误码
	 */
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return 错误信息
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg 错误信息
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "BaseModel [errcode=" + errcode + ", errmsg=" + errmsg + "] " + super.toString();
	}
}
/**
 * 
 */
package me.djin.weixin.pojo.sns;

import me.djin.weixin.util.Constant;
import me.djin.weixin.util.StringUtils;

/**
 * 手机号信息
 * 
 * @author djin
 *
 */
public class Phone {
	/**
	 * 用户绑定的手机号（国外手机号会有区号）, 一般情况下只使用此字段即可
	 */
	private String phoneNumber;
	/**
	 * 没有区号的手机号
	 */
	private String purePhoneNumber;
	/**
	 * 区号
	 */
	private String countryCode;

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the purePhoneNumber
	 */
	public String getPurePhoneNumber() {
		return purePhoneNumber;
	}

	/**
	 * @param purePhoneNumber the purePhoneNumber to set
	 */
	public void setPurePhoneNumber(String purePhoneNumber) {
		this.purePhoneNumber = purePhoneNumber;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + StringUtils.getMaskString(phoneNumber, Constant.MASK_STRING)
				+ ", purePhoneNumber=" + StringUtils.getMaskString(purePhoneNumber, Constant.MASK_STRING)
				+ ", countryCode=" + countryCode + "] " + super.toString();
	}
}

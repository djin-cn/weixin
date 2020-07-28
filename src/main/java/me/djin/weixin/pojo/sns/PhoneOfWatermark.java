package me.djin.weixin.pojo.sns;

/**
 * 带水印的手机号
 * 
 * @author djin
 *
 */
public class PhoneOfWatermark extends Phone {
	/**
	 * 水印
	 */
	private Watermark watermark;

	/**
	 * @return the watermark
	 */
	public Watermark getWatermark() {
		return watermark;
	}

	/**
	 * @param watermark the watermark to set
	 */
	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}

	@Override
	public String toString() {
		return "PhoneOfWatermark [watermark=" + watermark + "] " + super.toString();
	}
}

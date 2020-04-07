/**
 * 
 */
package me.djin.weixin;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import me.djin.weixin.api.BaseSns;

/**
 * @author djin 微信接口实例对象
 */
public class ApiInstance {
	private static final String WEIXIN_URL_PREFIX = "https://api.weixin.qq.com/";
	public static BaseSns createBaseSns() {
		//feign.okhttp.enabled=true
		return Feign.builder()
				.client(new OkHttpClient())
				.decoder(new GsonDecoder())
				.target(BaseSns.class, WEIXIN_URL_PREFIX);
	}
}

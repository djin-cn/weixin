/**
 * 
 */
package me.djin.weixin;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import me.djin.weixin.api.Sns;
import me.djin.weixin.util.Constant;

/**
 * @author djin 微信接口实例对象
 */
public class ApiInstance {
	private static final String WEIXIN_URL_PREFIX = "https://api.weixin.qq.com/";

	public static Sns createBaseSns() {
		// feign.okhttp.enabled=true
		return Feign.builder().client(new OkHttpClient()).decoder(new GsonDecoder()).target(Sns.class,
				WEIXIN_URL_PREFIX);
	}

	public static void main(String[] args) {
		Constant.LOGGER.info(Constant.LOG_FORMAT, ApiInstance.class.getName(), "main", "输出消息");
	}
}

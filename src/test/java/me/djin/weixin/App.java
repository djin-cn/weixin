package me.djin.weixin;

import me.djin.weixin.api.Sns;
import me.djin.weixin.pojo.sns.SnsAccessTokenResponse;

/**
 * Hello world!
 */
public class App {
	private static final String APPID = "wx4387723e1b0098a0";
	private static final String APPSECRET = "7fc41aadb16b85c1176b6d6d7d4e13ee";

	public static void main(String[] args) {
		System.out.println("start");
		testBaseSns_getUserAccessToken();
		System.out.println("end");
	}

	public static void testBaseSns_getUserAccessToken() {
		Sns sns = ApiInstance.createBaseSns();
		SnsAccessTokenResponse response = sns.accessToken(APPID, APPSECRET,
				"081NZwU12sjUMU0wQTW12DleU12NZwUY");
		System.out.println(response);
	}
}

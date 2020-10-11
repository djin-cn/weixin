package me.djin.weixin.api;

import org.junit.Test;

import me.djin.weixin.ApiInstance;
import me.djin.weixin.Constant;
import me.djin.weixin.pojo.sns.AccessToken;

public class BaseSnsTest {
	private Sns svcBaseSns = ApiInstance.createBaseSns();

	@Test
	public void testGetUserAccessToken() {
		AccessToken response = svcBaseSns.accessToken(Constant.APPID, Constant.APPSECRET,
				"081NZwU12sjUMU0wQTW12DleU12NZwUY");
		System.out.println(response);
	}
}

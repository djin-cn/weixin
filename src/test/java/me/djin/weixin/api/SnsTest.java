package me.djin.weixin.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;

import me.djin.weixin.ApiInstance;
import me.djin.weixin.Constant;
import me.djin.weixin.pojo.sns.AccessToken;

public class SnsTest {
	private Logger logger = me.djin.weixin.util.Constant.LOGGER;
	private Sns svcBaseSns = ApiInstance.createBaseSns();

	@Test
	public void testGetUserAccessToken() throws Exception {
		AccessToken response = svcBaseSns.accessToken(Constant.APPID, Constant.APPSECRET,
				"081NZwU12sjUMU0wQTW12DleU12NZwUY");
		assertNotNull(response);
		assertNotNull(response.getErrcode());
		if (0 != response.getErrcode()) {
			throw new Exception("code:" + response.getErrcode() + ", message:" + response.getErrmsg());
		}
		logger.info("accessToken获取成功");
	}
}

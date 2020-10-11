/**
 * 
 */
package me.djin.weixin;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import me.djin.weixin.encrypt.AesException;
import me.djin.weixin.pojo.cgi.ComponentInfo;

/**
 * @author djin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxRequestProcessTest {
	private MockHttpServletRequest request = new MockHttpServletRequest();

	@Test
	public void decryptEventRequest() throws IOException, AesException, ParserConfigurationException, SAXException {
		ComponentInfo componentInfo = new ComponentInfo();
		componentInfo.setAppId(Constant.APPID);
		componentInfo.setEncodingAESKey(Constant.ENCODING_AES_KEY);
		componentInfo.setToken(Constant.TOKEN);
		me.djin.weixin.util.Constant.LOGGER.info(componentInfo.toString());
		WxRequestProcess.decryptEventRequest(request, componentInfo);

		// TODO: 单元测试decryptEventRequest
	}
}

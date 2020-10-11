package me.djin.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		me.djin.weixin.util.Constant.LOGGER.info("SpringBoot start...");
		SpringApplication.run(App.class, args);
		me.djin.weixin.util.Constant.LOGGER.info("SpringBoot end!");
	}
}

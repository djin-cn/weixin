/**
 * 
 */
package me.djin.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常量
 * 
 * @author djin
 *
 */
public interface Constant {
	/**
	 * 分隔符, 用于toString时集合转字符串
	 */
	String SEPARATOR = "|";
	/**
	 * 时间戳键
	 */
	String TIMESTAMP_KEY = "timestamp";
	/**
	 * 随机数键
	 */
	String NONCE_KEY = "nonce";
	/**
	 * 加密类型键
	 */
	String ENCRYPT_TYPE_KEY = "encrypt_type";
	/**
	 * 消息体签名, 用于验证消息体的正确性
	 */
	String MSG_SIGNATURE_KEY = "msg_signature";
	/**
	 * 日志输出
	 */
	Logger LOGGER = LoggerFactory.getLogger("weixin_module");
	/**
	 * 日志输出格式
	 */
	String LOG_FORMAT = "class:{}; method:{}; - {}";
	/**
	 * 掩码符号
	 */
	String MASK_STRING = "*";
}

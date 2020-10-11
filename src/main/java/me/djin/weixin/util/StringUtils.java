/**
 * 
 */
package me.djin.weixin.util;

import java.util.Collections;

/**
 * 字符串工具类
 * 
 * @author djin
 *
 */
public class StringUtils {
	/**
	 * 获取字符串的掩码字符串, 主要用于对敏感信息进行隐藏
	 * 
	 * @param text 原始字符串
	 * @param mask 掩码格式, 默认为*
	 * @return
	 */
	public static String getMaskString(String text, String mask) {
		if (text == null || text == "") {
			return text;
		}
		if (mask == null || mask == "") {
			mask = "*";
		}
		int length = text.length();
		if (length == 1) {
			return mask;
		}
		if (length <= 3) {
			return text.charAt(0) + String.join("", Collections.nCopies(length - 1, mask));
		}
		if (length == 11) {
			return text.substring(0, 3) + String.join("", Collections.nCopies(4, mask)) + text.substring(7, 11);
		}
		int started = (int) Math.ceil((double) length / 8);
		int maskLength = length - started * 2;
		int endIndex = length - started;
		return text.substring(0, started) + String.join("", Collections.nCopies(maskLength, mask))
				+ text.substring(endIndex);
	}

	public static void main(String[] args) {
		String len1 = "a";
		String len2 = "ab";
		String len3 = "abc";
		String len4 = "abcd";
		String len5 = "abcde";
		String len10 = "abcdefghij";
		String len11 = "13838384438";
		String len12 = "abcdefghijkl";
		String len26 = "abcdefghijklmnopqrstuvwxyz";

		System.out.println(getMaskString(len1, "#"));
		System.out.println(getMaskString(len2, "#"));
		System.out.println(getMaskString(len3, "#"));
		System.out.println(getMaskString(len4, "#"));
		System.out.println(getMaskString(len5, "#"));
		System.out.println(getMaskString(len10, "#"));
		System.out.println(getMaskString(len11, "#"));
		System.out.println(getMaskString(len12, "#"));
		System.out.println(getMaskString(len26, "#"));
	}
}

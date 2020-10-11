/**
 * 
 */
package me.djin.weixin.util;

import java.util.Collection;

/**
 * @author djin
 *
 */
public final class CollectionUtils {
	/**
	 * 集合转换为String, 如果collection为NULL或者Empty, 则返回空字符串
	 * 
	 * @param <T>
	 * @param collection 集合
	 * @param separator  分隔符, 默认为空字符串
	 * @return
	 */
	public static <T> String toString(Collection<T> collection, String separator) {
		if (collection == null || collection.isEmpty()) {
			return "";
		}
		if (separator == null) {
			separator = "";
		}
		StringBuilder sb = new StringBuilder();
		for (T t : collection) {
			sb.append(t.toString());
			sb.append(separator);
		}
		if (!separator.isEmpty()) {
			return sb.substring(0, sb.length() - 1);
		}
		return sb.toString();
	}
}

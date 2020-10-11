/**
 * 
 */
package me.djin.weixin.pojo.cgi;

import java.util.List;

import me.djin.weixin.util.CollectionUtils;
import me.djin.weixin.util.Constant;

/**
 * 微信分页模型
 * 
 * @author djin
 *
 */
public class Page<T> {
	/**
	 * 总数量
	 */
	private Long total_count;
	/**
	 * 结果集/结果列表
	 */
	private List<T> list;

	/**
	 * @return the total_count
	 */
	public Long getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [total_count=" + total_count + ", list=" + CollectionUtils.toString(list, Constant.SEPARATOR)
				+ "] " + super.toString();
	}
}

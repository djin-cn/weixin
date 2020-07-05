package me.djin.weixin.pojo.cgi;

/**
 * 权限集
 * 
 * @author djin
 *
 */
public class FunctionInfo {
	/**
	 * 权限集/权限域
	 */
	private FunctionScope funcscope_category;

	/**
	 * @return the funcscope_category
	 */
	public FunctionScope getFuncscope_category() {
		return funcscope_category;
	}

	/**
	 * @param funcscope_category the funcscope_category to set
	 */
	public void setFuncscope_category(FunctionScope funcscope_category) {
		this.funcscope_category = funcscope_category;
	}

	@Override
	public String toString() {
		return "FunctionAuth [funcscope_category=" + funcscope_category + "] " + super.toString();
	}

	/**
	 * 权限集
	 * 
	 * 具体可参考连接
	 * {@link https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/func_info.html}
	 * 
	 * @author djin
	 *
	 */
	public static class FunctionScope {
		/**
		 * 权限集ID/权限域ID
		 */
		private String id;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "FunctionScope [id=" + id + "] " + super.toString();
		}
	}
}
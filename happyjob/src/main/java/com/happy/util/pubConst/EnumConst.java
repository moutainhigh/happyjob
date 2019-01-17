package com.happy.util.pubConst;

/**
 * 		枚举转换
 * @author zhuoyuqing
 *
 */
public class EnumConst {

	public enum companyApproveState  {

		WithoutApprove(0, "未认证"), ApproveYes(1, "认证通过"), ApproveNo(3, "认证不通过");

		private Integer key;
		private String value;

		private companyApproveState(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
	
	public enum advertisementUseOn  {
		
		UseOnNo(0, "关闭"), UseOnYse(1, "开启");

		private Integer key;
		
		private String value;

		private advertisementUseOn(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
	
	public enum advertisementDelOn  {
		
		DelOnNo(0, "未删除"), DelOnYse(1, "删除");

		private Integer key;
		private String value;

		private advertisementDelOn(Integer key, String value) {
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
	
	
}

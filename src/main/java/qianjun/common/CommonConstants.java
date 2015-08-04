package qianjun.common;

public class CommonConstants {

	/**
	 * 一些数据库表的主键序列名称
	 */
	public enum SequenceName{
		USER_ID("user_id"),
		T_PROVIDER_LINE_SERIAL("t_provider_line_serial"),
		T_PROVIDER_LINE_SEQUENCE("t_provider_line_sequence"),
		T_OPERATOR_LINE_SERIAL("t_operator_line_serial"),
		T_OPERATOR_LINE_SEQUENCE("t_operator_line_sequence"),
		// 团号用序列
		T_PROVIDER_GROUP_ID("t_provider_group_id"),
		// 预订单缓存用KEY值
		PREORDER_KEY("preorder_key"),
		// 退团申请用的id
		QUIT_GROUP_KEY("quit_group_key"),
		// 调价表用的id
		ADJUST_PRICE_KEY("adjust_price_key"),
		/**
		 * 订单航期
		 */
		ORDER_LINE_PERIOD_ID("t_order_line_period_id"),
		/**
		 * 订单ID
		 */
		CRUISE_ORDER_ID("cruise_order_id"),
		/**
		 * 订单联系人Id
		 */
		CRUISE_ORDER_CONTACT_ID("cruise_order_contact_id"),
		/**
		 * 旅客Id
		 */
		CRUISE_ORDER_PASSENGER_ID("cruise_order_passenger_id"),
		/**
		 * 支付订单Id
		 */
		CRUISE_ORDER_PAY_ID("cruise_order_pay_id"),
		/**
		 * 售价规则ID
		 */
		CRUISE_SALE_RULE_ID("cruise_sale_rule_id"),
		/**
		 * 售价规则日志Id
		 */
		CRUISE_SALE_RULE_LOG_ID("cruise_sale_rule_log_id");
		private String value;
		private SequenceName(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}

	}
	/**
	 * 基础数据的分组信息
	 * @author tangtianjiang
	 *
	 */
	public enum BaseDataTypeGroup{
		/**
		 * 邮轮公司类型
		 */
		GROUP_CRUISE_COMPANY_TYPE("group_cruise_company_type"),
		GROUP_CRUISE_COMPANY("group_cruise_company"),
		GROUP_CRUISE_TYPE("group_cruise_type"),
		GROUP_PORT_TYPE("group_port_type"),
		GROUP_REGION_TYPE("group_region_type"),
		GROUP_LABEL("group_label"),
		GROUP_CRUISE("group_cruise"),
		GROUP_CABIN_TYPE("group_cabin_type"),
		GROUP_PROVIDER("group_provider"),
		GROUP_VISA("group_visa"),//签证
		GROUP_CABIN("group_cabin"),
		GROUP_COMMON("group_common"),
		GROUP_ORDER_STATUS("GROUP_ORDER_STATUS"),
		GROUP_ID_TYPE("GROUP_ID_TYPE"),
		GROUP_PASSENGER_QUIT_STATUS("GROUP_PASSENGER_QUIT_STATUS"),
		GROUP_PASSENGER_QUIT_REASON("GROUP_PASSENGER_QUIT_REASON");
		private String groupName;
		private BaseDataTypeGroup(String groupName){
			this.groupName = groupName;
		}
		public String groupName(){
			return groupName;
		}
	}

	public enum OperBaseDataType{

	}

	/*public enum OrderPayStatus{
		PAYING
	}*/

	public enum BaseDataField{
		GROUP("group"),
		PARENT_CODE("parentCode"),
		CONTENT_CN("contentCN"),
		CONTENT_EN("contentEN"),
		CODE("code"),
		TAG("tag");
		private String fieldName;
		private BaseDataField(String fieldName){
			this.fieldName = fieldName;
		}
		public String fieldName(){
			return fieldName;
		}
	}
	public enum ParamsKey{
		OBJECT_ID("objectId");
		private String key;
		private ParamsKey(String key){
			this.key = key;
		}
		public String key(){
			return this.key;
		}
	}
	public enum PriceType {
		FS,	//同舱一二人价
		TFA,	//同舱三四成人价
		TFC,	//同舱三四儿童价
		SG		//单人价
	}
	public static final String CRUISE_PREFIX = "cruise-";
}

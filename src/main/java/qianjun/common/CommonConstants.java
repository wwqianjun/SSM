package qianjun.common;




/**
 * 
 * @author muyuansun, etc.
 */
public class CommonConstants {
	
	/**
	 * SESSION 超时时间 单位为秒
	 */
	public static final long SESSION_TIMEOUT = 1*60*30;
	/**
	 * 后台管理公司默认 company_id
	 */
	public static final String BACK_COMPANY_ID = "-1";
	
	/**
	 * 后台默认的超级用户
	 */
	public static final String SUPER_USER = "superuser";
	
	/**
	 * 系统用户
	 */
	public static final String SYS_USER_ID = "sys";
	
	/**
	 * 后台默认的超级用户
	 */
	public static final String SUPER_USER_ID = "8888";
	
	/**
	 * 验证码 SESSISON KEY
	 */
	public static final String CAPTCHA_SESSION_KEY = "B2G_CAPTCHA_SESSION_KEY";
	
	/**
	 * 验证码 REQUEST KEY
	 */
	public static final String CAPTCHA_REQUEST_KEY = "j_captcha";
	
	/**
	 * 默认政策编码
	 */
	public static final String DEFAULT_POLICY_CODE = "0";
	
	/**
	 * 酒店城市分级相关在mongo中对应的groupId
	 */
	public static final String HOTEL_CITY_GROPE_IN_MONGO = "hotelCityLevel";
	
	/**
	 * 月份对应的英文缩写
	 */
	public static String[] months = new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	/**
	 * 购物车ID前缀
	 */
	public final static String SHOPPING_CART_ID_PREX = "shopping_cart_";
	/**
	 * 登录的用户名前缀
	 * 向redis中记录加的前缀
	 */
	public final static String CHECK_USERNAME_PREX = "LOGIN_NAME_";
	
	/**
	 * 登录失败的登录名
	 */
	public final static String CHECK_FAILED_LOGINNAME = "ERR_LOGINNAME";
	
	/**
	 * 登录失败校验次数，大于此值的时候将出现验证码
	 */
	public final static int CHECK_FAILED_LOGIN_TIME = 3;
	/**
	 * 默认的登陆密码,当导入的用户是冻结状态的时候，使用此默认密码作为默认密码
	 * 也将作为判断是否为第一次解冻，作为补救判断是否为第一次激活的字段
	 */
	public final static String DEFAULT_PASSWORD = "Abc123_.dl;";
	
	/**
	 * 日志文件路径
	 */
	public final static String logConfig = "/logback";
	/** 
	 * @author tangtianjiang
	 *
	 */
	public enum ToastMsg{
		/**
		 * 缓存数据已丢失的提示信息
		 */
		QUERY_CACHE_NULL("缓存数据已清，请确定当前预订是否已提交或操作是否超时！"),
		/**
		 * 缓存信息不一致时的提示信息
		 */
		QUERY_CACHE_ERROR("预订信息存在异常，请重新预订！"),
		/**
		 * 选择的商品已添加过购物车
		 */
		SHOPPING_ITEM_HAS_ADD("当前查询已提交过，预订新的行程请重新搜索"),
		/**
		 * 舱位已售完
		 */
		FLIGHT_SELL_CLEAR("您选择的价格舱位已售完，请选择其他舱位！"),
		/**
		 * 通用的系统内部问题
		 */
		INNER_ERROR("系统异常，请稍后重试");
		private String msg;
		private ToastMsg(String msg){
			this.msg = msg;
		}
		public String msg(){
			return this.msg;
		}
	}
	
	public enum B2GAppConfigurationKey{
		CANCEL_PNR_TRIGGER("cancel.pnr.trigger"),
		B2G_TIMEOUT_ORDER_TRIGGER("b2g.timeout.order.trigger"),
		AIRPLUS_GENERATE_FILE_TRIGGER("airplus.generate.file.trigger"),
		B2G_SYN_ORDER_STATUS_TRIGGER("b2g.syn.order.status.trigger"),
		B2G_MONTH_BATCH_TRIGGER("b2g.month.batch.trigger");
		private String name;
		private B2GAppConfigurationKey(String name) {
			this.name = name;
		}
		public String keyName() {
			return name;
		}
	}
	
	/**
	 * 
	 * TODO 区分国内国际 
	 * @author TangTianJiang
	 * @date 2013年12月13日 下午9:06:24
	 */
	public enum FlightType{
		DOMESTIC,
		INTERNATIONAL
	}
	
	public enum QueryFlightType{
		DOMESTIC_OW("domestic_ow"),
		DOMESTIC_RT("domestic_rt"),
		DOMESTIC_CJ("domestic_cj"),
		INTERNATIONAL_OW("international_ow"),
		INTERNATIONAL_RT("international_rt");
		private String value;
		private QueryFlightType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	public enum FlightOrderType{
		NORMAL("0"),
		REFUND("1"),
		INVALID("2"),
		ENDORSE("3");
		private String value;
		private FlightOrderType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	public enum QueryTypeEnum{
		FLIGHT,
		HOTEL
	}
	/**
	 * 购物车内商品的类型
	 * @author TangTianJiang
	 * @date 2014年2月14日 上午11:51:44
	 */
	public enum ShoppingCartType{
		DOMESTIC_OW("domestic_ow"),
		DOMESTIC_RT("domestic_rt"),
		DOMESTIC_CJ("domestic_cj"),
		INTERNATIONAL_OW("international_ow"),
		INTERNATIONAL_RT("international_rt"),
		DOMESTIC_HOTEL("domestic_hotel");
		private String value;
		private ShoppingCartType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	/**
	 * 菜单的国际化key(用到的请自行添加)
	 * TODO
	 * @author TangTianJiang
	 * @date 2013年12月20日 下午1:46:30
	 */
	public enum MenuKey{
		TRAVEL_BOOK("menu.travel_book");
		private String menuName;
		private MenuKey(String menuName){
			this.menuName = menuName;
		}
		public String menuName(){
			return menuName;
		}
	}
	/**
	 * thrift连接池默认配置
	 * @author muyuansun
	 *
	 */
	public enum ThriftConnctionConfiguration{
		/**
		 *  thrift连接池默认配置文件路径
		 */
		THRIFT_CONNECTION_DEFAULT_CONFIGURATION_FILE("thrift/connection/thrift-connection-default.xml");
		private String info;
		private ThriftConnctionConfiguration(String info){
			this.info = info;
		}
		public String info(){
			return info;
		}
	}
	
	/**
	 * 
	 * @author yanyu
	 */
	public enum AutoCompleteServerConfigurationFile{
		AUTO_COMPLETE_SERVER("config/auto_complete_server.xml");
		private String path;
		private AutoCompleteServerConfigurationFile(String path){
			this.path = path;
		}
		public String path(){
			return path;
		}
	}
	/**
	 * 页面路径的常量（添加请写上注释）
	 * TODO
	 * @author TangTianJiang
	 * @date 2013年12月20日 下午1:39:24
	 */
	public enum ViewNames{
		/**
		 * 登陆页面
		 */
		LOGIN("/page/login/login.html"),
		
		/**
		 * 移动端登陆页面
		 */
		LOGINMOBILE("/page/login/loginMobile.html"),
		/**
		 * 登陆页面
		 */
		ACCESS_DENIED("/page/login/accessDenied.html"),
		/**
		 * 登陆页面
		 */
		ACCESS_DENIED_MOBILE("/page/login/accessDeniedMobile.html"),
		/**
		 * 信息显示页面
		 */
		MESSAGE_INFO("/page/common/common_info.html"),
		/**
		 * 错误信息提示页面
		 */
		MESSAGE_ERROR("/page/common/common_error.html"),
		/**
		 * 异常信息的嵌入页面
		 */
		ABOUT_BLANK("/page/common/about_blank.html"),
		/**
		 * 行程预订页面
		 */
		MENU_TRAVEL_BOOK("/page/menuPage/travel_book.html"),
		MENU_TRAVEL_MANAGE("/page/menuPage/travel_manage.html"),
		MENU_TRAVEL_DATA("/page/menuPage/data_service.html"),
		/**
		 * 数据服务,对账页面
		 */
		DATA_CHECK_ACT("/page/dataService/check_act.html"),
		
		
		MENU_COMPANY_MANAGE("/page/member/costCenter/costCenterList.html"),
		MENU_SYSTEM_SETTING("/page/menuPage/system_setting.html"),
		/**
		 * 单程国际机票页面 international_ow_flight.html
		 */
		INTERNATIONAL_FLIGHT_OW_PAGE("/page/internationalFlight/oneway/international_ow_flight.html"),
		
		/**
		 * 查询单程国际机票数据刷新模版
		 */
		INTERNATIONAL_FLIGHT_ONE_WAY_QUERYLIST_PAGE("/page/internationalFlight/oneway/international_one_way_flight_query_list.html"),
		/**
		 * 只显示更多条目
		 */
		INTERNATIONAL_FLIGHT_ONE_WAY_QUERY_MORELIST_PAGE("/page/internationalFlight/oneway/international_one_way_more_item.html"),
		/**
		 * 往返国际机票页面
		 */
		INTERNATIONAL_FLIGHT_ROUND_WAY_PAGE("/page/internationalFlight/round/international_rt_flight.html"),
		/**
		 * 查询往返国际机票数据刷新模版
		 */
		INTERNATIONAL_FLIGHT_ROUND_WAY_QUERYLIST_PAGE("/page/internationalFlight/round/international_round_way_flight_query_list.html"),
		/**
		 * 单程国内机票页面
		 */
		DOMESTIC_FLIGHT_OW_PAGE("/page/domesticFlight/domestic_ow_flight.html"),
		/**
		 * 往返国内机票去程页面
		 */
		DOMESTIC_FLIGHT_RT_PAGE("/page/domesticFlight/domestic_rt_flight.html"),
		/**
		 * 往返国内机票返程页面
		 */
		DOMESTIC_FLIGHT_RT_RETURN_PAGE("/page/domesticFlight/domestic_rt_return_flight.html"),
		/**
		 * 带返回的错误页面（返回到主搜索页面）
		 */
		COMMON_EORROR_PAGE_WITH_BACK("/page/common/error_with_back.html"),
		/**
		 * 机票预订页面
		 */
		FLIGHT_BOOK_PAGE("/page/flightBook/book_edit.html"),
		/**
		 * 行程订单核对页面
		 */
		TRAVEL_ORDER_TO_CHECK_PAG("/page/book/travelOrderToCheck.html"),
		/**
		 * 后台下单页面
		 */
		BACKGROUND_CREATE_TRAVEL_ORDER("/page/customerService/createTravelOrder.html"),
		BACK_ORDER_ANALYSIS("/page/customerService/backOrderAnalysis.html"),
		BACK_PROXY_APPROVE("/page/customerService/proxyApprove.html"),
		
		/**
		 * 临时订单管理页面
		 */
		TEMPORARY_ORDER_MANAGE("/page/customerService/temporaryOrderManage.html"),
		/**
		 * 正式的后台订单管理页面
		 */
		FORMAL_ORDER_MANAGE("/page/customerService/formalOrderManage.html"),
		BACKSTAGE_FLIGHT_ORDER("/page/customerService/backstageFlightOrderItem.html"),
		
		/**
		 * 不要重复提交的页面
		 */
		NOT_RESUBMIT("/page/book/not_resubmit.html"),
		
		/**
		 * 酒店搜索列表页
		 */
		HOTEL_DOMESTIC_LIST_PAGE("/page/hotel/domestic/hotel_list.html"),
		HOTEL_DOMESTIC_MAP_PAGE("/page/hotel/domestic/map.html"),
		HOTEL_DOMESTIC_IMAGES_PAGE("/page/hotel/domestic/images.html"),
		/**
		 * 酒店详情页面
		 */
		HOTEL_DETAILS_PAGE("/page/hotel/hotelDetail/hotelDetailsPage.html"),
		/**
		 * 酒店预订页面
		 */
		HOTEL_BOOK_PAGE("/page/hotel/domesticBook/hotel_book_edit.html"),
		
		/**
		 * 系统设置页面
		 */
		OPEN_COMPANY_ADD_NEW_ROLE_PAGE("/page/systemSetting/company/companyAddNewRole.html"),
		/**
		 * 系统设置真旅角色新增页面
		 */
		OPEN_TRAVELZEN_ADD_NEW_ROLE_PAGE("/page/systemSetting/travelzen/travelzenAddNewRole.html"),
		/**
		 * 系统设置真旅页面
		 */
		TRAVELZEN_ROLE_PAGE("/page/systemSetting/travelzen/travelzenRolePage.html"),
		/**
		 * 系统设置集团客户页面
		 */
		GROUP_ROLE_PAGE("/page/systemSetting/company/groupRolePage.html"),
		
//		activiti测试
		ACTIVITI_TEST("/page/testPage/activitiPage.html"),
		ACTIVITI_DATA("/page/testPage/activitiData.html"),
		
		INNER_ERROR("/page/common/500.html"),
		NOT_FOUND_ERROR("/page/common/404.html");
		private String viewName;
		private ViewNames(String viewName){
			this.viewName = viewName;
		}
		public String viewName(){
			return viewName;
		}
	}
	
	
	/**
	 * 一些数据库表的主键序列名称
	 * @author muyuansun
	 * @date 2014-1-26 下午2:29:32
	 */
	public enum SequenceName{
		USER_ID("user_id"),
		PRODUCT_ORDER_ID("product_order"),
		T_AIRPLUS_SEQID("airplus_id"),
		T_ID_USER_USERID("user_id"),
		T_ID_USER_CARD_CARDID("card_id"),
		T_ID_COST_CENTER_CENTERID("center_id"),
		T_ID_DEPARTMENT_DEPTID("dept_id"),
		T_ID_APPROVE_FLOW_FLOWID("flow_id"),
		T_ID_APPROVE_RELATION_RELATIONID("relation_id"),
		T_ID_CARRIER_VIP_CARDID("carrier_vip_card_id"),
		T_ID_SEC_SECID("sec_id"),
		T_ID_COMPANYITEM_COMPANYITEMID("company_item_id"),
		T_ID_COMPANY_COMPANYID("company_id"),
		T_ID_ROLE_ROLEID("role_id"),
		T_ID_TRAVELPOLICY_POLICYID("policy_id"),
		T_ID_DATA_RIGHT_TYPE_DATARIGHTTYPEID("data_right_type_id"),
		T_ID_PERMISSION_PERM_ID("perm_id"),
		SHOPPING_CART_ITEM_ID("shopping_cart_item_id"),
		T_ID_CREDITCARD_ID("creditCard_id"),
		T_O_ORDER_LOG_ID("log_id"),
		T_B_SHOPPINGPNR_PNRID("pnr_id"),
		T_M_MESSAGE_ID("msg_id"),
		BASE_DATA_CONTENT_ENTITY_ID("base_data_content_entity_id");
		
		private String value;
		private SequenceName(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		
	}
	public enum MsgError{
		/**
		 * 删除PNR错误
		 */
		PNRERROR_DELETE("PNRERROR01"),
		/**
		 * 位置错误
		 */
		PNRERROR_UNKNOWN("PNRERROR02");
		private String msgId;
		private MsgError(String msgId){
			this.msgId = msgId;
		}
		public String msgId(){
			return msgId;
		}
	}
	public enum EncapsulationElongConfigurationKey{
		ELONG_ENCAPSULATION_INTERFACE_URI("elong.encapsulation.interface.uri");
		private String name;
		private EncapsulationElongConfigurationKey(String name){
			this.name = name;
		}
		public String keyName(){
			return name;
		}
	}
	
	public enum BaseDataEnum{
		/**
		 * 基础数据group种类
		 * @author tangtianjiang
		 *
		 */
		;
		
		public enum BaseDataGroupType{
			SEX("sex"),
			/**
			 * 城市国家基础数据
			 * 出自b2g-mongo/src/main/resources/basedata/country_city_code.xls
			 */
			COUNTRY_CITY("country_city_code"),
			/**
			 * 国家基础数据
			 * 出自b2g-mongo/src/main/resources/basedata/country_city_code.xls
			 */
			COUNTRY_CODE("country_code"),
			/**
			 * 国内航班搜索界面基础数据
			 * 航班类型 航班舱位等级 航班时间 航空公司
			 * 出自b2g-mongo/src/main/resources/basedata/domesticSearchDataBase.xls
			 */
			DOMESTIC_FLIGHT_ROUTE_TYPE("domestic_flight_route_type"),
			DOMESTIC_FLIGHT_CLASS_TYPE("domestic_flight_class_type"),
			DOMESTIC_FLIGHT_TIME("domestic_flight_time"),
			DOMESTIC_FLIGHT_COMPANY("domestic_flight_company"),
			/**
			 * 机场代码基础数据
			 * 出自b2g-mongo/src/main/resources/basedata/AirportCode.xls
			 */
			AIRPORT_CODE("airport_code"),
			/**
			 * 航空公司代码基础数据
			 * 出自b2g-mongo/src/main/resources/basedata/AirLine.xls
			 */
			AIRLINE_CODE("airline_code"),
			/**
			 * 航空公司缩写基数数据
			 * 出自b2g-mongo/src/main/resources/basedata/AirLine.xls
			 */
			AIRLINE_CODE_ABB("airline_code_abb"),
			CLASS_CODE("class_code");
			private String groupType;
			private BaseDataGroupType(String groupType){
				this.groupType = groupType;
			}
			public String groupType(){
				return groupType;
			}
		}
		/**
		 * 基础数据字段名
		 * @author tangtianjiang
		 *
		 */
		public enum BaseDataField{
			GROUP("group"),
			PARENTID("parentId"),
			DATAID("dataId"),
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
	}
	/**
	 * 乘客类型（成人/儿童）
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月9日 下午5:50:31
	 */
	public enum TravellerType{
		ADULT("A"),
		CHILD("C");
		private String type;
		private TravellerType(String type){
			this.type = type;
		}
		public String type(){
			return type;
		}
	}
	
	/**
	 * 行程类型
	 * TODO
	 * @author TangTianJiang
	 * @date 2013年12月27日 下午2:16:35
	 */
	public enum TripType{
		ONE_WAY("OW"),
		ROUND_WAY("RT");
		private String type;
		private TripType(String type){
			this.type = type;
		}
		public String type(){
			return this.type;
		}
	}
	/**
	 * 机票搜索默认页数
	 */
	public static int FLIGHT_DEFAULT_DEFAULT_SIZE = 10;
	/**
	 * 机票搜索默认页码
	 */
	public static int FLIGHT_DEFAULT_DEFAULT_INDEX = 0;
	/**
	 * 拆分后的订单返回数据的一些KEY
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月14日 下午2:24:25
	 */
	public enum SplitOrderParams{
		FLIGHT_PNR,
		ISSUE_TIME
	}
	/**
	 * 基本参数的KEY
	 * @author TangTianJiang
	 * @date 2014年2月12日 上午10:01:23
	 */
	public enum BasicQueryParamsKey{
		/**
		 * 查询数据ID
		 */
		BOOK_QUERY_ID("bookQueryId");
		private String key;
		private BasicQueryParamsKey(String key){
			this.key = key;
		}
		public String key(){
			return key;
		}
	}
	
	/**
	 * 配置文件需要的key
	 * @author muyuansun
	 * @date 2014-3-20 下午6:31:09
	 */
	public enum Configuration {
		
		DEFAULT("default");
		
		private String key;
		
		private Configuration(String key){
			this.key = key;
		}
		public String key(){
			return key;
		}
		
		public enum ThriftServer {
			
			ZOOKEEPER_BE_USED_MANAGE_SERVICE("zookeeper.be.used.manage.service"),
			ZOOKEEPER_MONITOR_SERVICE_PATH("zookeeper.monitor.service.path"),
			ZOOKEEPER_CONNECTION_STRING("zookeeper.connection.string"),
			ZOOKEEPER_PATHCHILDREN_CALLBACK_LISTENER("zookeeper.pathchildren.callback.listener");
			
			private String value;
			private ThriftServer(String value) {
				this.value = value;
			}
			public String KEY() {
				return value;
			}
		}
		
	}
	
	public enum ConfigurationFile {
		
		DEFAULT("default");
		private String key;
		private ConfigurationFile(String key){
			this.key = key;
		}
		public String key(){
			return key;
		}
		/**
		 * 封装的接口配置文件，目前只有Elong
		 * @author muyuansun
		 * @date 2014-3-12 下午2:50:54
		 */
		public enum EncapsulationInterface{
			ELONG_INTERFACE("configuration/elong_interface.xml"),
			ELONG_FRAMEWORK_INTERFACE("configuration/hotel/elong/elong_interface.xml");
			private String path;
			private EncapsulationInterface(String path){
				this.path = path;
			}
			public String PATH(){
				return path;
			}
		}
		
		public enum ELONG{
			ELONG_CONFIGURATION_PATH("configuration/elong_configuration.xml"),
			ELONG_FRAMEWORK_CONFIGURATION_PATH("configuration/hotel/elong/elong_configuration.xml");
			private String path;
			private ELONG(String path){
				this.path = path;
			}
			public String PATH(){
				return path;
			}
		}
		
		public enum ProjectConfig {
			B2G_WEB("configuration/b2g/b2g-web.xml");
			private String value;
			private ProjectConfig(String value) {
				this.value = value;
			}
			public String PATH() {
				return value;
			}
		}
		
		public enum ThriftServer {
			
			AUTO_COMPLETE_SERVICE("configuration/thrift/server/auto_complete_service_thrift_server.xml"),
			FLIGHT_SERVICE("configuration/thrift/server/flight_service_thrift_server.xml"),
			HOTEL_SERVICE("configuration/thrift/server/hotel_service_thrift_server.xml"),
			ELONG_SPOTPAY_SERVICE("configuration/thrift/server/elong_spotpay_service_thrift_server.xml"),
			TEST_SERVICE("configuration/thrift/server/test_service_thrift_server.xml");
			
			private String value;
			private ThriftServer(String value) {
				this.value = value;
			}
			public String PATH() {
				return value;
			}
		}
		
	}
	
	/**
	 * 国际机票查询参数对应的key
	 * TODO
	 * @author TangTianJiang
	 * @date 2013年12月24日 下午1:25:47
	 */
	public enum InternationalQueryParamsKey{
		/**
		 * 出发城市三字码
		 */
		FROM_CITY_CODE("fromCityCode"),
		/**
		 * 目的城市三字码
		 */
		TO_CITY_CODE("toCityCode"),
		/**
		 * 行程类型
		 */
		TRIP_TYPE("tripType"),
		/**
		 * 出发时间
		 */
		SEARCH_FROM_DATE("searchFromDate"),
		
		/**
		 * 回程时间
		 */
		SEARCH_BACK_DATE("searchBackDate"),
		/**
		 * 乘机人类型（成人/儿童）
		 */
		SEARCH_PERSON_KIND("searchPersonKind"),
		/**
		 * 舱位等级
		 */
		SEARCH_CLASS("searchClass"),
		/**
		 * 航司
		 */
		AIRLINE_CODE("airlineCode"),
		/**
		 * 起飞时间
		 */
		SEARCH_FLIGH_TTIME("searchFlightTime"),
		/**
		 * 飞行类型 直飞/中转
		 */
		FLIGHT_TYPE("flightType"),
		/**
		 * 预订类型
		 */
		BOOK_TYPE("bookType"),
		/**
		 * 差旅人
		 */
		TRAVELLERS("travellers");
		
		private String key;
		private InternationalQueryParamsKey(String key){
			this.key = key;
		}
		public String key(){
			return key;
		}
		
		/**
		 * 自动补全和openapi的thrift服务接口配置文件
		 * @author muyuansun
		 * @date 2013-12-24 下午10:01:04
		 */
		public enum ThriftServerConfigurationFile{
			HOTEL_SERVICE("thrift/server/hotel_service_thrift_server.xml"),
			FLIGHT_SERVICE("thrift/server/flight_service_thrift_server.xml"),
			AUTO_COMPLETE_SERVICE("thrift/server/auto_complete_thrift_server.xml");
			private String path;
			private ThriftServerConfigurationFile(String path){
				this.path = path;
			}
			public String path(){
				return path;
			}
		}
		/**
		 * 
		 * TODO
		 * @author TangTianJiang
		 * @date 2014年1月2日 下午4:05:25
		 */
		public enum UtilIDGenerKeys{
			DOMESTIC_OW_FLIGHT("domestic_ow_flight"),
			DOMESTIC_RT_FLIGHT("domestic_rt_flight"),
			DOMESTIC_FLIGHT_CABIN_ITEM("domestic_flight_cabin_item"),
			DOMESTIC_FLIGHT_BOOK_QUERY_ID("domestic_flight_book_query_"),
			INTERNATIONAL_FLIGHT_BOOK_QUERY_ID("international_flight_book_query_"),
			DOMESTIC_HOTEL_BOOK_QUERY_ID("domestic_hotel_book_query_");
			private String key;
			private UtilIDGenerKeys(String key){
				this.key = key;
			}
			public String key(){
				return key;
			}
		}
		
		//行程订单状态
		public enum ForeOrderStatus{
			NEW("-1", "无需审批"),//无需审批
			PENDING("0", "待审批"),//待审批
			APPROVING("1", "审批中"),//审批中
			APPROVED("2", "审批通过"),//审批通过
			PARTIAL_REFUSED_OR_EXPIRED("3", "部分退回/失效"),//部分退回/失效
			REFUSED_OR_EXPIRED("4", "退回/失效"),//全部退回/失效
			UNPAID("5", "待付款"),//待付款
			PROCESSING("6", "处理中"),//处理中
			FINISHED("7", "已完成"),//已完成
			REFUNDING_OR_CHANGING("8", "退改签中"),//退改签中
			CANCELLED("9", "已取消");//已取消		
			
			private String value;
			private String text;
			private ForeOrderStatus(String value, String text) {
				this.value = value;
				this.text = text;
			}
			public String getValue() {
				return value;
			}
			public String getText(){
				return text;
			}
			
		}
		
		//主订单状态
		public enum TopOrderStatus{
			NEW("-1", "无需审批"),//无需审批
			PENDING("0", "待审批"),//待审批
			APPROVING("1", "审批中"),//审批中
			APPROVED("2", "审批通过"),//审批通过
			REFUSED_OR_EXPIRED("4", "退回/失效"),//退回/失效
			UNPAID("5", "待付款"),//待付款
			PROCESSING("6", "处理中"),//处理中
			FINISHED("7", "已完成"),//已完成
			REFUNDING_OR_CHANGING("8", "退改签中"),//退改签中
			CANCELLED("9", "已取消");//已取消		
			
			private String value;
			private String text;
			private TopOrderStatus(String value, String text) {
				this.value = value;
				this.text = text;
			}
			public String getValue() {
				return value;
			}
			public String getText(){
				return text;
			}
		}
		
		//机票子订单状态
		public enum B2GFlightOrderStatus{			
			NEW(-1),//新建
			WAIT_PAY(0),//待支付
			WAIT_AUDIT(1),//待审核
			AUDIT_FALSE(2),//审核失败
			CANCELED(3),//已取消
			WAIT_ISSUE(4),//待出票
			PAY_FALSE(5),//支付失败
			ISSUE_FALSE(6),//出票失败
			ISSUED(7),//出票完成
			ISSUING(8),//出票中
			AUDITING(9),//审核中
			AUDITED(10),//审核通过
			REFUNDING(11),//退废票中
			REFUND_FALSE(12),//退废失败
			REFUND_FINISH(13),//退废完成
			ENDORSING(14),//改签中
			ENDORSE_FALSE(15),//改签失败
			ENDORSE_FINISH(16),//改签完成
			PAYING(22);//支付中
			
			private int value;
			private B2GFlightOrderStatus(int value) {
				this.value = value;
			}
			public int getValue() {
				return value;
			}
		}
		
		//酒店子订单状态
		public enum HotelOrderStatus{
			BEGIN(-1),//初始状态
		    INIT_CREATE(0),//平台已建单
		    WAITING_CONFIRM(1),//等待确认
		    CONFIRM_FALSE(2),//确认不通过，对应艺龙订单的状态G变价、O满房、U特殊满房、P暂无价格
			CANCEL_COMPLETE(-2),//已取消
			CONFIRM_COMPLETE(7);//已确认
//		    checkIn_complete("已入住"),
//		    not_checkIn("未入住"),
//		    closed_account("已结帐"),
//		    unsettled_account("未结帐"); 
			
			private int value;
			private HotelOrderStatus(int value) {
				this.value = value;
			}
			public int getValue() {
				return value;
			}			
		}
		
		
		//票价类型
		public enum PriceType{
			ADULT_FARE,//成人票面价
			CHILD_FARE,//儿童票面价
			ADULT_SETTLEMENT_FARE,//成人结算价
			CHILD_SETTLEMENT_FARE;//儿童结算价
		}
	}
	
	//用户任务状态
	public enum UserTaskStatus{
		WAITAPPROVE("0"),//待审批
		COMPLETE("1"),//通过
		REFUSED("2");//拒绝
		
		private String value;
		private UserTaskStatus(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	/**
	 * 价格或税费种类
	 * @author TangTianJiang
	 * @date 2014年3月3日 下午4:55:14
	 */
	public enum PriceOrTaxType{
		ADULTFACEPRICE,
		CHILDFACEPRICE,
		ADULTSETTLEPRICE,
		CHILDSETTLEPRICE,
		ADULTALLTAX,
		CHILDALLTAX
	}
	
	public enum CompareReultType{
		LAGER,
		SMALLER,
		EQUEAL,
		LAGERANDEQUEAL,
		SMALLERANDEQUEAL
	}
	
	public enum OrderType{
		MAIN_ORDER("0"),
		FORE_ORDER("1");
		

		private String value;
		private OrderType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		
		/**
		 * 根据value值获取当前的枚举类型
		 * @param value
		 * @return
		 */
		public static OrderType getOrderTypeByValue(String value){
			for(OrderType orderType : OrderType.values()){
				if(orderType.getValue().equals(value)){
					return orderType;
				}
			}
			return null;
		}
	}
	public enum GuaranteeType {  
		  NO_NEED,//无条件担保
		  ROOM_AMOUNT,//房型数量
		  ROOM_ARRIVE_TIME, //到达房间时间担保
		  BOTH;  //两者都需要
	}  
	
	public enum UserState{
		ACTIVITY("0"),//正常
		DELETE("1"),//删除
		FREEZE("2");//冻结
		
		private String value;
		private UserState(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	
	public enum CompanyApproveRule{
		NONE("N"),
		DEPARTMENT_COST_CENTER("DC"),
		PERSON("P"),
		COST_CENTER("C")
		;
		private String value;
		private CompanyApproveRule(String value) {
			this.value = value;
		}
		public String Rule() {
			return value;
		}
	}
	
	public enum TravellerSimpleType {
		NORMAL(0),
		TEMPORARY(1),
		VIOLATION(2);

		private int value;
		private TravellerSimpleType(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
	/**
	 * 表中PNR的状态
	 * @author TangTianJiang
	 * @date 2014年3月20日 下午6:39:03
	 */
	public enum TOPNRStatus{
		/**
		 * 正常状态
		 */
		STATUS_NOMAL("1"),
		/**
		 * 从购物车删除
		 */
		DELETE_FROM_SHOPPING_CART("-3"),
		/**
		 * 添加购物车失败，删除
		 */
		ADD_FAIL_SHOPPING_CART("-4");
		private String status;
		private TOPNRStatus(String status){
			this.status = status;
		}
		public String status(){
			return status;
		}
	}
	
	public enum CardType{
		PSPT("0"),//身份证
		PASSPORT("1"),//护照
		TAIWAN("2"),//入台证
		HKMACAO("3"),//港澳通行证
		OTHER("4");//其他证件
		private String value;
		private CardType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	
	/**
	 * 权限查询类型
	 * @author zhengzhichao
	 *
	 */
	public enum PermQueryType{
		TRAVELZEN,//真旅权限列表
		BUSSINESS;//集团用户权限列表
	}
	
	/**
	 * 权限划分
	 * @author zhengzhichao
	 *
	 */
	public enum PermSysType{
		PUBLIC("P"),//公有权限
		TRAVELZEN("T"),//真旅专有权限
		COMPANY("C");//集团用户专有权限
		
		private String value;
		private PermSysType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	
	/**
	 * 公司消息通知设置，相关订单状态
	 * @author zhengzhichao
	 *
	 */
	public enum OrderFlowState{
		CREATE("0"),//创建
		WAIT_APPROVE("1"),//待审批
		APPROVE_SUCCESS("2"),//审批通过
		APPROVE_REFUSE("3"),//审批拒绝
		WAIT_PAY("4"),//待付款
		COMPLETE("5");//完成
		
		private String value;
		private OrderFlowState(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
		
		/**
		 * 根据value值获取当前的枚举类型
		 * @param value
		 * @return
		 */
		public static OrderFlowState getMsgTypeByValue(String value){
			for(OrderFlowState orderFlowState : OrderFlowState.values()){
				if(orderFlowState.getValue().equals(value)){
					return orderFlowState;
				}
			}
			return null;
		}
	}
	
	/**
	 * 公司消息通知设置，消息通知方式
	 * @author yanyu
	 *
	 */
	public enum NotifyMethod{
		SYSTEM_MSG("0"),//系统消息
		EMAIL("1"),//邮件
		SMS("2");//短信

		private String value;
		private NotifyMethod(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	
	/**
	 * 公司消息通知设置，接收对象
	 * @author yanyu
	 *
	 */
	public enum MsgReceiver{
		APPROVER("0"),//审批人
		RESERVATOR("1"),//预订人
		TRAVELLER("2"),//差旅人
		CONTACTOR("3");//差旅联系人

		private String value;
		private MsgReceiver(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}			
	}
	
	/**
	 * 消息类型
	 * @author zhengzhichao
	 *
	 */
	public enum MsgType{
		ALERT("0"),//提醒
		WAIT_APPROVE("1"),//待审批
		WAIT_PAY("2"),//待付款
		APPROVE_OK("3"),//审批通过
		APPROVE_REFUSE("4"),//审批拒绝
		COMPLETE("5");//订单完成

		private String value;
		private MsgType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}		
		
		/**
		 * 根据value值获取当前的枚举类型
		 * @param value
		 * @return
		 */
		public static MsgType getMsgTypeByValue(String value){
			for(MsgType msgType : MsgType.values()){
				if(msgType.getValue().equals(value)){
					return msgType;
				}
			}
			return null;
		}
	}
	
	/**'
	 * 机票的配送方式
	 * @author qianjun
	 *@date 2014-08-22 13：26
	 */
	public enum DeliveryPay{
		//配送方式 0不配送 1邮寄 2送票 
		不配送,邮寄,送票 ;
	}
	/**
	 * 机票的配送的名字 1：配送行程单 2：配送发票
	 * @author QianJun
	 * @date 2014-08-22 14:56
	 */
	public enum DeliveryName{
		配送行程单(1),
		配送发票(2);
		private int value;
		private DeliveryName(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}		
	}
	
	public enum ReportName{
		FLIGHT_COST_DETAIL,//机票费用明细
		CITY_PAIR_DETAIL,//城市对明细
		AIR_COMPANY_DETAIL,//承运商明细
		FLIGHT_CABIN_DETAIL,//机票舱位明细
		ADVANCE_DAYS_DISCOUNT_DETAIL,//提前天数与折扣明细
		TRIPARTITE_STATISTICS,//三方协议统计
		LOSS_DETAIL,//损失明细
		SAVE_DETAIL,//节约明细
		PERSONAL_TRAVEL_COST_RANK,//个人差旅费用排名
		COST_CENTER_SUMMARY//成本中心差旅汇总
	}
	
	/**
	 * 下载报表名字，现在是重用，今后重构下载
	 * @author QianJun
	 *
	 */
	public enum ReportDownType{
		CHECK_ACT("实时对账"),//实时对账
		COST_CENTER_DETAIL("成本中心差旅明细"),//成本中心差旅明细
		LOSS_DETAIL("损失明细"),//损失明细
		SAVE_DETAIL("节约明细");
		
		private String value;
		private ReportDownType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}	
	}
}//End CommonConstants

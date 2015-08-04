package qianjun.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ParamUtils {
	private static Logger LOG = LoggerFactory.getLogger(ParamUtils.class);
	public static boolean checkListtringEmpty(List<String> strList) {
		for (String str : strList) {
			if (str != null && str.length() > 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断list是否为空
	 * @author TangTianJiang
	 * @date 2014年2月21日 下午8:03:33
	 * @param objs
	 * @return 不为空 true   为空 false
	 */
	public static <T> boolean checkListNotEmpty(List<T> objs){
		if (null != objs && !objs.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断对象中是否都不为空
	 * @author TangTianJiang
	 * @date 2014年2月22日 下午5:23:21
	 * @param params
	 * @return 都不为空返回true，存在空值返回false
	 */
	public static boolean checkObjectsNotNull(Object ... params){
		if (null == params || !(params.length>0)) {
			return false;
		}
		for (Object param : params) {
			if (null == param) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 检测是否存在空的字符串
	 * TODO
	 * @author TangTianJiang
	 * @date 2014年1月4日 下午2:21:09
	 * @param params
	 * @return 存在空的值返回false 反之返回为true
	 */
	public static boolean checkStringArrayNotEmpty(String ... params){
		if (null == params || !(params.length>0)) {
			LOG.info("不存在校验的字符串数组");
			return false;
		}
		for (String param : params) {
			if (null == param || param.trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @author TangTianJiang
	 * @date 2014年9月17日 下午2:49:48
	 * @param str
	 * @return
	 */
	public static boolean checkStringNotEmpty(String str){
		if (null == str || str.trim().equals("")) {
			return false;
		}
		return true;
	}
	
	
	public static <T> String listLink(List<T> source, String separator) {
		if (source == null) {
			return null;
		}

		if (separator == null) {
			return null;
		}
		String temp = "";
		for (T s : source) {
			temp = stringBufferAppendStrings("",  temp , separator , s.toString());
		}

		temp = temp.replaceFirst(separator, "");
		return temp;
	}

	public static List<String> intToStrList(int value) {
		return Arrays.asList(new String[] { String.valueOf(value) });
	}

	public static List<String> longToStrList(long value) {
		return Arrays.asList(new String[] { String.valueOf(value) });
	}

	public static Collection<String> getStringCollection(String str) {
		List<String> values = new ArrayList<String>();
		if (str == null)
			return values;
		StringTokenizer tokenizer = new StringTokenizer(str, ",");
		values = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()) {
			values.add(tokenizer.nextToken());
		}
		return values;
	}

	public static String[] getStrings(String str) {
		Collection<String> values = getStringCollection(str);
		if (values.size() == 0) {
			return null;
		}
		return values.toArray(new String[values.size()]);
	}

	public static String arrayToString(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		StringBuffer sbuf = new StringBuffer();
		sbuf.append(strs[0]);
		for (int idx = 1; idx < strs.length; idx++) {
			sbuf.append(",");
			sbuf.append(strs[idx]);
		}
		return sbuf.toString();
	}
	
	@SuppressWarnings("deprecation")
	public static Map<String, String> convertObjectToParamsMap(Object object){
		
		try {
			/**
			 * 将bean转为map,方便前段js的封装
			 */
			
			BeanUtils.setDebug(3);
			@SuppressWarnings("unchecked")
			Map<String, String> searchDataMap = BeanUtils.describe(object);
			if (null != searchDataMap) {
				if (searchDataMap.containsKey("class")) {
					searchDataMap.remove("class");
				}
			}
			return searchDataMap;
		} catch (Exception e) {
			return null;
		}
	}

	public static Map<String, String> requestParamsToMap(Map<String, String[]> paramsAndValues){
		Map<String, String> params = new HashMap<String, String>();
		for (Entry<String, String[]> entry : paramsAndValues.entrySet()) {
			String[] values = entry.getValue();
			if (null != values && values.length > 0) {
					params.put(entry.getKey(), values[0]);
			}
		}
		return params;
	}; 
	/**
	 * 将字符拼接到StringBuffer
	 * @author TangTianJiang
	 * @date 2014年3月17日 下午4:11:28
	 * @param defaultStr 当参数为null时，默认的字符串，当设为null时，不拼接
	 * @param params
	 * @return
	 */
	public static String stringBufferAppendStrings(String defaultStr, String ... params){
		if( null == params){
			return defaultStr;
		}
		StringBuffer sb = new StringBuffer();
		for (String str : params) {
			if (null != str) {
				sb.append(str);
			}else{
				if (null != defaultStr) {
					sb.append(defaultStr);
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 判断字符串是否由字母和空格组成
	 * @author tangtianjiang
	 * @param assertStr
	 * @return
	 */
	public static boolean assertIsLetterOrSpaceString(String assertStr){
		if (!ParamUtils.checkStringArrayNotEmpty(assertStr)) {
			return false;
		}
		String patternStr = "^[a-zA-z\\s]+";
		return assertStr.matches(patternStr);
	}
	
	public static boolean assertIsLetter(String assertStr){
		if (!ParamUtils.checkStringArrayNotEmpty(assertStr)) {
			return false;
		}
		String patternStr = "^[a-zA-z]+";
		return assertStr.matches(patternStr);		
	}
	
	/**
	 * 判断字符串是否相等，空格与null视为相等,不区分大小写
	 * tangtianjiang
	 * 2013年12月4日 下午7:09:47
	 * @param val1 比较字符串1
	 * @param val2 比较字符串2
	 * @return 返回比较的结果，空格与null视为相等，不区分大小写
	 */
	public static boolean equalCompareInIngnoreNull(String val1, String val2){
		if (null == val1 || val1.trim().equals("")) {
			if (null == val2 || val2.trim().equals("")) {
				return true;
			}
			return false;
		}else{
			if (null != val2) {
				return val1.trim().equalsIgnoreCase(val2.trim());
			}
			return false;
		}
	}
	
	/**
	 * 检查字符串是否都为空
	 * @param params
	 * @return
	 */
	public static boolean checkStringArrayAllEmpty(String ... params){
		if (null == params || !(params.length>0)) {
			return false;
		}
		for (String param : params) {
			if (param != null && !param.trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 检查数组是否不为空,或均为不为空的值
	 * @param params
	 * @return
	 */
	public static boolean checkObjectNotEmptyAndAllNotNull(Object... params){
		if (null == params || !(params.length>0)) {
			return false;
		}
		for (Object obj : params) {
			if (null == obj) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkEntityRequiredParams(Map<String, String> entityMap,String... checkkeys) throws CommonException{
		if (null == entityMap) {
			return false;
		}else if (checkkeys.length == 0) {
			return true;
		}
		for (String string : checkkeys) {
			if (ParamUtils.checkStringNotEmpty(string)) {
				String value = entityMap.get(string);
				if (!ParamUtils.checkStringNotEmpty(value)) {
					throw CommonException.instance(ParamUtils.stringBufferAppendStrings("", string,"不能为空"));
				}
			}
		}
		return true;
	}
	public static int praserIntWithCatchException(String intStr) throws Exception{
		if (!checkStringNotEmpty(intStr)) {
			throw new Exception();
		}
		int result = Integer.parseInt(intStr);
		return result;
	}
	public static boolean checkEntityRequiredParamsExist(Map<String, String> entityMap,String... checkkeys) {
		if (null == entityMap) {
			return false;
		}else if (checkkeys.length == 0) {
			return true;
		}
		for (String string : checkkeys) {
			if (ParamUtils.checkStringNotEmpty(string)) {
				String value = entityMap.get(string);
				if (!ParamUtils.checkStringNotEmpty(value)) {
					return false;
				}
			}
		}
		return true;
	}

	public static <T> boolean checkEntityParams(String key, Class<T> entity) throws CommonException{
		Map<String, String> entityMap;
		try {
			entityMap = ParamUtils.convertObjectToParamsMap(entity.newInstance());
		} catch (Exception e) {
			
			throw CommonException.instance(ParamUtils.stringBufferAppendStrings("", "内部异常"),e);
		} 
		if (ParamUtils.checkStringNotEmpty(key)) {
			if (!entityMap.containsKey(key.trim())) {
				throw CommonException.instance(ParamUtils.stringBufferAppendStrings("", "非法的查询参数：",key));
			}
		}
		
		
		return true;
	}
}

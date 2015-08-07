package qianjun.common;

import qianjun.common.CommonConstants.CompareReultType;



public class CommonUtils {
	/**
	 * 按条件比较数据（第一个数对比第二个数）
	 * @author TangTianJiang
	 * @date 2014年7月28日 下午1:58:33
	 * @param value1 
	 * @param value2
	 * @param type
	 * @return
	 */
	public static boolean compareDoubleNum(Double value1, Double value2, CompareReultType type){
		if (value1 == null || value2 == null) {
			return false;
		}
		int compareResult = value1.compareTo(value2);
		switch (type) {
		case LAGER:
			if (compareResult == 1) {
				return true;
			}
			return false;
		case EQUEAL:
			if (compareResult == 0) {
				return true;
			}
			return false;
		case SMALLER:
			if (compareResult == -1) {
				return true;
			}
			return false;
		case LAGERANDEQUEAL:
			if (compareResult == 1 || compareResult == 0) {
				return true;
			}
			return false;
		case SMALLERANDEQUEAL:
			if (compareResult == -1 || compareResult == 0) {
				return true;
			}
			return false;
		default:
			return false;
		}
	}
}

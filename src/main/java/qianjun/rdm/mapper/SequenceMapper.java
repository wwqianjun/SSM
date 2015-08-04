package qianjun.rdm.mapper;

import java.util.Map;

public interface SequenceMapper {
	/**
	 * 根据序列名称和请求序列个数，获取一个新的序列
	 * @param sequenceName 序列名称
	 * @param allotment 请求序列个数
	 * @return
	 */
	public Long getNextSequence(Map<String, Object> param);
	
	/**
	 * 根据序列名称，获取当前序列的最大值
	 * @param sequenceName
	 * @return
	 */
	public Long getSeqMaxValue(String sequenceName);
}

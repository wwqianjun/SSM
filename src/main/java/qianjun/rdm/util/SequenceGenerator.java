package qianjun.rdm.util;

import qianjun.common.CommonException;
import qianjun.common.SpringAppContext;
import qianjun.service.impl.SequenceService;

/**
 * 将原序列生成策略稍作修改，原策略如果使用不当可能会导致产生重复序列的bug
 * 另外添加直接获取带有时间戳序列的方法
 * @author zhengzhichao
 *
 */
public class SequenceGenerator {
	
	private static SequenceService sequenceService = SpringAppContext.getBean(SequenceService.class);
	
	/**
	 * 根据序列名字，获取新的序列
	 * 序列名字需要去tops_journey.sequence表中配置，否则将会抛出找不到序列的异常
	 * 配置序列的时候，需指定序列名字：seq_name  当前序列值：current_value  递增步长：increment  最大值：max_value
	 * 按照oracle序列生成规则，超过最大值的序列将重新开始
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getNextSeq(String sequenceName) throws CommonException{
		return sequenceService.getNextSeq(sequenceName);
	}
	
	/**
	 * 根据序列名字获取序列，在序列头部加上8位时间维度，精确到天(yyyyMMdd)
	 * @param sequenceName
	 * @return 带有时间维度的序列
	 * @throws Exception
	 */
	
	public static synchronized String getNextSeqWithDate(String sequenceName) throws CommonException{
		return sequenceService.getNextSeqWithDate(sequenceName);
	}
	
	/**
	 * 根据序列名字获取序列，在序列头部加上12位时间维度，精确到秒(yyMMddHHmmss)
	 * @param sequenceName
	 * @return 带有时间维度的序列
	 * @throws Exception
	 */	
	public static synchronized String getNextSeqWithDate12(String sequenceName) throws Exception{
		return sequenceService.getNextSeqWithDate12(sequenceName);
	}
}

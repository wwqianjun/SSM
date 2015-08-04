package qianjun.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import qianjun.common.CommonException;
import qianjun.common.ParamUtils;
import qianjun.rdm.mapper.SequenceMapper;
/**
 * 将原序列生成策略稍作修改，原策略如果使用不当可能会导致产生重复序列的bug
 * 另外添加直接获取带有时间戳序列的方法
 * @author zhengzhichao
 *
 */
@Service("sequenceService")
public class SequenceService {
	private static Map<String,SequencePool> seqMap = new HashMap<String,SequencePool>();
	
	@Autowired
	private SequenceMapper sequenceMapper;
	
	//每次请求分配的序列数个数
	private static final int allotment = 1;
	
	/**
	 * 从数据库获取序列，能够批量获取
	 * @param sequenceName 序列名称
	 * @param allotment 获取序列个数
	 * @return
	 * @throws Exception
	 */
	private long getNextSeq(String sequenceName, int allotment) throws CommonException{
    	HashMap<String, Object> parameters = new HashMap<String, Object>();
    	parameters.put("sequenceName", sequenceName);
    	parameters.put("allotment", allotment);
    	Long result = sequenceMapper.getNextSequence(parameters);
    	if(null==result){
    		throw CommonException.instance(ParamUtils.stringBufferAppendStrings("","找不到序列：",sequenceName));
    	}
    	return result;
    }
    
	/**
	 * 获取序列最大值
	 * @param seqName
	 * @return
	 * @throws Exception
	 */
    private long getSeqMaxValue(String seqName) throws CommonException{
    	Long result = sequenceMapper.getSeqMaxValue(seqName);
    	if(null==result){
    		throw CommonException.instance(ParamUtils.stringBufferAppendStrings("","找不到序列：",seqName));
    	}
    	return result;
    }
	
	/**
	 * 根据序列名字，获取新的序列
	 * 序列名字需要去tops_journey.sequence表中配置，否则将会抛出找不到序列的异常
	 * 配置序列的时候，需指定序列名字：seq_name  当前序列值：current_value  递增步长：increment  最大值：max_value
	 * 按照oracle序列生成规则，超过最大值的序列将重新开始
	 * 
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.REPEATABLE_READ)
	public synchronized String getNextSeq(String sequenceName) throws CommonException{
		SequencePool pool = seqMap.get(sequenceName);
		if(seqMap.get(sequenceName) == null || pool.isEmpty()){
			pool = refillPool(sequenceName);
			seqMap.put(sequenceName, pool);
		}
		return formatSequence(String.valueOf(pool.next()),pool.getMaxValue());
	}
	
	/**
	 * 格式化时间
	 * @param formatStr  输入参数为java的标准格式化日期字符串 类似 yyyy-MM-dd hh:mm:ss
	 * @return 返回系统当前时间
	 */
	private String getFormatDateTime(String formatStr) throws CommonException{
//		DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatDate = null;
		DateFormat format = null;
		try{
			format = new java.text.SimpleDateFormat(formatStr);
		}catch (Exception e) {
			throw CommonException.instance("请确认日期格式化字符串输入正确！",e);
		}
		formatDate = format.format(new Date());
	    return formatDate;
	}
	/**
	 * 根据序列名字获取序列，在序列头部加上8位时间维度，精确到天(yyyyMMdd)
	 * @param sequenceName
	 * @return 带有时间维度的序列
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String getNextSeqWithDate(String sequenceName) throws CommonException{
		StringBuilder ret = new StringBuilder();
		ret.append(getFormatDateTime("yyyyMMdd"));
		ret.append(getNextSeq(sequenceName));
		return ret.toString();
	}
	
	/**
	 * 根据序列名字获取序列，在序列头部加上12位时间维度，精确到秒(yyMMddHHmmss)
	 * @param sequenceName
	 * @return 带有时间维度的序列
	 * @throws Exception
	 */	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String getNextSeqWithDate12(String sequenceName) throws CommonException{
		StringBuilder ret = new StringBuilder();
		ret.append(getFormatDateTime("yyMMddHHmmss"));
		ret.append(getNextSeq(sequenceName));
		return ret.toString();
	}
	
	
	/**
	 * 批量获取序列，减少访问数据库次数
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	private SequencePool refillPool(String sequenceName) throws CommonException{
		long nextSeq = getNextSeq(sequenceName,allotment);
		long seqMaxValue = getSeqMaxValue(sequenceName);
		return new SequencePool(nextSeq, nextSeq + allotment -1,seqMaxValue); 
	}
	/**
	 * 
	 * description: 根据当前序列的最大值，格式序列，不足的位数左侧补零
	 * 
	 * 修改为用StringBuilder拼接字符串，增加拼接速度！
	 * @param is 当前序列
	 * @param maxValue	序列最大值
	 * @return
	 */
	private String formatSequence(String is, long maxValue) {
		int width = new Long(maxValue).toString().length();
		StringBuilder tempStr = new StringBuilder();
		int count = width-is.length();
		for(int i=0;i<count;i++){
			tempStr.append(0);
		}
		return tempStr.append(is).toString();
	}
	
	
	private class SequencePool{
		private long low;
		private long high;
		private long maxValue;//索引最大值 超过最大值将从1开始
		private long currentValue;//索引当前值
		public SequencePool(long low, long high,long maxValue){
			this.low = low;
			this.high = high;
			this.maxValue = maxValue;
		}
		
		/**
		 * 获取下一个索引
		 * @return
		 */
		public long next() {
			if(low != this.maxValue){
				currentValue = low%maxValue;
			}else{
				currentValue = low;
			}
			low++;
			return currentValue;
		}
		public boolean isEmpty(){
			return low > high;
		}
		
		public long getMaxValue(){
			return this.maxValue;
		}
	}
}

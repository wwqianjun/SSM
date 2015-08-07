package qianjun.common;
/**
 * 校验的返回实体
 * TODO checkResult为校验的结果，checkBackObj为检验后需要返回的实体
 * @author TangTianJiang
 * @param <T>
 * @date 2014年1月9日 下午9:49:05
 */
public class CheckEnableMsgEntity<T>{
	private boolean checkResult;
	private T checkBackObj;
	
	public CheckEnableMsgEntity(){
		
	}
	
	public CheckEnableMsgEntity(boolean checkResult, T checkBackObj){
		this.checkResult = checkResult;
		this.checkBackObj = checkBackObj;
	}
	
	public boolean isCheckResult() {
		return checkResult;
	}
	public void setCheckResult(boolean checkResult) {
		this.checkResult = checkResult;
	}
	public T getCheckBackObj() {
		return checkBackObj;
	}
	public void setCheckBackObj(T checkBackObj) {
		this.checkBackObj = checkBackObj;
	}
	
	
}

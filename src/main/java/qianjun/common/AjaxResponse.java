package qianjun.common;


/**
 * 用来封装ajax请求返回值，统一处理错误，异常等信息
 * @author zhengzhichao
 */
public class AjaxResponse {
	private AjaxResponseStatus status;//ajax请求返回状态，是否处理成功
	private String message;//ajax请求返回message
	/**
	 * 请求返回的数据，data中的对象必须是spring mvc能够自动识别转换的
	 */
	private Object data;
	
	/**
	 * 设置异常，将异常信息返回
	 * @param e
	 */
	public void setException(Exception e){
		this.status = AjaxResponseStatus.FAILED;
		this.message = e.getMessage();
	}
	
	public AjaxResponseStatus getStatus() {
		return status;
	}
	public void setStatus(AjaxResponseStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public enum AjaxResponseStatus {
		//请求成功
        SUCCESS,
        //请求失败
        FAILED
    }
}

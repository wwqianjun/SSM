package qianjun.common;

public enum ReturnCode {
	ERROR("E00500"),
	ERROR_NULL("E00501");

	private String errorCode;

	ReturnCode(String code) {
		errorCode = code;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


}

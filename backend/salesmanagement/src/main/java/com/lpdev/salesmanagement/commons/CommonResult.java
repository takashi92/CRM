package com.lpdev.salesmanagement.commons;

public class CommonResult {

	private boolean isSuccess;
	private String message;
	private Object data;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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
	
	public static CommonResult getResult(boolean isSuccess, String message, Object data) {
		CommonResult commonResult = new CommonResult();
		commonResult.setSuccess(isSuccess);
		commonResult.setMessage(message);
		commonResult.setData(data);
		return commonResult;
	}
}

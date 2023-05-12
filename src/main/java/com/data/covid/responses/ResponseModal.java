package com.data.covid.responses;

public class ResponseModal {
	private Integer statusCode;
	private Object responseData;
	private String message;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package com.lab.common;

public class RestResponse<T> {

	private int code;
	private String msg;
	private T result;

	public static <T> RestResponse<T> success(int code, String msg, T result) {
		RestResponse<T> response = new RestResponse<T>(code, msg, result);
		response.setCode(code);
		response.setMsg(msg);
		response.setResult(result);
		return response;
	}

	public static <T> RestResponse<T> error(int code, String msg) {
		return new RestResponse<T>(code, msg);
	}

	public RestResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public RestResponse(int code, String msg, T result) {
		this.code = code;
		this.msg = msg;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RestResponse [code=" + code + ", msg=" + msg + ", result=" + result + "]";
	}

}
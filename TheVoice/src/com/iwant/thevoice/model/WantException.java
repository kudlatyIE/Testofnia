package com.iwant.thevoice.model;

public class WantException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1226657398943872378L;
	private int exceptionCode;
	private String exceptionMessage;
	private ExceptionCode exception;
	
//	public WantException(int code, String msg){
//		this.exceptionCode=code;
//		this.exceptionMessage=msg;
//	}

	public WantException(ExceptionCode exception){
		this.exception=exception;
	}
	
	public ExceptionCode getWantException() {
		return exception;
	}

	public void setWantException(ExceptionCode exception) {
		this.exception = exception;
	}
	
	public int getWantExceptionCode(){
		return exception.getCode();
	}
	
	public String getWantExceptionMessage(){
		return exception.getMsg();
	}

//	public int getExceptionCode() {
//		return exceptionCode;
//	}
//
//	public void setExceptionCode(int exceptionCode) {
//		this.exceptionCode = exceptionCode;
//	}
//
//	public String getExceptionMessage() {
//		return exceptionMessage;
//	}
//
//	public void setExceptionMessage(String exceptionMessage) {
//		this.exceptionMessage = exceptionMessage;
//	}
	
	

}

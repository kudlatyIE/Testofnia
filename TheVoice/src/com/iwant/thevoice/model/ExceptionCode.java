package com.iwant.thevoice.model;

import java.util.HashMap;

public enum ExceptionCode {
	
	EX_LOCALISATION(1001, "UNKNOWN LOCALISATION!");
	
	
	private int code;
	private String msg;
	
	ExceptionCode(int code, String msg){
		this.code=code;
		this.msg=msg;
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
	
	public static HashMap<Integer, String> getErrMap(){
		HashMap<Integer, String>map =new HashMap<Integer,String>();
		for(ExceptionCode c: ExceptionCode.values()){
			map.put(c.getCode(), c.getMsg());
		}
		return map;
	}

}

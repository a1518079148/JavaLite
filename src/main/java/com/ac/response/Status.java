package com.ac.response;

/**
 * @author JIN
 */
public enum Status {
	/**
	 * 服务调用成功
	 */
	OK						(200),
	/** 
	 * 调用服务的参数不符合要求
	 */
	BAD_PARAMETER			(400),
	/** 
	 * 不符合业务处理的要求
	 */
	NOT_MEET_BIZ			(401),
	/** 
	 * 没有调用服务的权限
	 */
	FORBIDDEN				(403),
	/**
	 * 服务未找到
	 */
	NOT_FOUND				(404),
	/**
	 * 服务超时
	 */
	TIMEOUT					(408),
	/**
	 * 服务内部异常
	 */
	ERROR					(500),
	/**
	 * 服务传递、分发过程出现异常
	 */
	BAD_ROUTE				(502),
	/**
	 * 登录超时（session过期）
	 */
	SESSION_EXPIRED			(502);

	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	@Override
	public String toString() {
		return String.valueOf(code);
	}
}

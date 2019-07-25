package app.service.impl;

public interface AuthServiceImpl {
	
	/**
	 * 用户登录获取token
	 */
	String getToken(String user_id);

	/**
	 * 用户操作验证token
	 */
	boolean isToken(String token);

	/**
	 * 用户操作更新token有效时长
	 */
	void upToken(String token);

	/**
	 * 通过token获取用户id
	 */
	String getUserId(String token);
	
}

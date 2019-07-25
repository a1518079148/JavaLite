package app.service.impl;

import org.bson.Document;

public interface UserServiceImpl {
	
	/**
	 * 用户登录验证
	 */
	String login(Document user);
	
	/**
	 * 获取用户信息
	 */
	Document getUserInfo(String id);
}

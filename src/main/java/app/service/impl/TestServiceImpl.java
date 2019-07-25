package app.service.impl;

import org.bson.Document;

/**
 * 测试
 */
public interface TestServiceImpl {
	
	/**
	 * 获取列表
	 */
	Document index();
	
	/**
	 * 创建详情
	 */
	void create();
	
	/**
	 * 更新详情
	 */
	void update();

	/**
	 * 删除详情
	 */
	void delete();
	
	/**
	 * 获取详情
	 */
	Document show();
	
}

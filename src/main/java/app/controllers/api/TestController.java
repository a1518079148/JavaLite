package app.controllers.api;

import org.javalite.activeweb.annotations.RESTful;

import com.google.inject.Inject;

import app.controllers.BaseController;
import app.service.impl.TestServiceImpl;

/**
 * RESTFul规范样例
 */
@RESTful
public class TestController extends BaseController {

	@Inject(optional = true)
	TestServiceImpl testService;

	/**
	 * 获取列表
	 */
	public void index() {
		testService.index();
		success("获取列表成功");
	}

	/**
	 * 创建详情
	 */
	public void create() {
		testService.create();
		success("创建详情成功");
	}

	/**
	 * 更新详情
	 */
	public void update() {
		testService.update();
		success("更新详情成功");
	}

	/**
	 * 获取详情
	 */
	public void show() {
		testService.show();
		success("获取详情成功");
	}

	/**
	 * 删除详情
	 */
	public void destroy() {
		testService.delete();
		success("删除详情成功");
	}
}

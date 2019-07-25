package app.controllers.sys;

import org.bson.Document;
import org.javalite.activeweb.annotations.RESTful;

import com.google.inject.Inject;

import app.controllers.BaseController;
import app.service.impl.UserServiceImpl;

@RESTful
public class UserController extends BaseController {
	@Inject
	UserServiceImpl userService;

	public void show() {
		Document doc = req();
		switch (getId()) {

		/**
		 * 用户登录
		 */
		case "login":
			success(userService.login(doc));
			break;
		default:
			break;
		}
	}
}

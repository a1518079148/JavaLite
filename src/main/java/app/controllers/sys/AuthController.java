package app.controllers.sys;

import org.javalite.activeweb.annotations.RESTful;

import com.google.inject.Inject;

import app.controllers.BaseController;
import app.service.impl.AuthServiceImpl;

@RESTful
public class AuthController extends BaseController {

	@Inject(optional = true)
	AuthServiceImpl authService;

	/**
	 * 获取详情
	 */
	public void show() {
		success("未知错误");
//		if(getId().equals("Javalite")) {
//			success(authService.isToken(header("token")));
//		}
	}

}

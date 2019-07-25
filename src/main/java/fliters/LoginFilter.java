package fliters;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;
import org.javalite.common.JsonHelper;

import com.ac.response.FailureResult;
import com.ac.response.Status;
import com.ac.support.StringUtils;
import com.google.inject.Inject;

import app.service.impl.AuthServiceImpl;

/**
 * 用户关键操作需要登陆拦截
 */
public class LoginFilter extends HttpSupportFilter {

	@Inject
	AuthServiceImpl authService;

	@Override
	public void before() {
		String token = header("token");
		if (StringUtils.isEmpty(token)) {
			res("请登录后再试！");
			return;
		} else if (!authService.isToken(token)) {
			res("请登录后再试！");
			return;
		}

	}

	private void res(String str) {
		String json = JsonHelper.toJsonString(new FailureResult<>(Status.ERROR, str));
		respond(json).contentType("application/json;charset=UTF-8");
	}
}

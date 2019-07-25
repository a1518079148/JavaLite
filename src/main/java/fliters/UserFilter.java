package fliters;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;

import com.google.inject.Inject;

import app.service.impl.AuthServiceImpl;

/**
 * 已登录用户操作token更新
 */
public class UserFilter extends HttpSupportFilter {

	@Inject
	AuthServiceImpl authService;

	@Override
	public void before() {
		String token = header("token");
		if (authService.isToken(token))
			authService.upToken(token);
	}
}

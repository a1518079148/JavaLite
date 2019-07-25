package app.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.bson.Document;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.RequestUtils;

import com.ac.exception.RException;
import com.ac.response.SuccessResult;
import com.ac.support.MongoUtils;
import com.google.inject.Inject;

import app.service.impl.AuthServiceImpl;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseController extends AppController {

	@Inject
	AuthServiceImpl authService;

	protected String getUserId() {
		String token = header("token");
		if (!authService.isToken(token))
			throw new RException("登录超时");
		return authService.getUserId(token);
	}

	/**
	 * 获取参数列表
	 */
	protected Document req() {

		if (values().containsKey("param_obj")) {
			return (Document) values().get("param_obj");
		}

		Document result = new Document();
		result.putAll((Map) RequestUtils.params1st());

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = getRequestInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}

			body = stringBuilder.toString();
			if (body != null && !body.equals("")) {
				result.putAll((MongoUtils.toMap(body)));
			}

			values().put("param_obj", result);
			logInfo("请求参数：" + result);
			return result;

		} catch (IOException ex) {
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
				}
			}
		}

		return new Document();
	}

	/**
	 * 后端接口回调规范附带message提示
	 */
	public void success(String message, Object data) {
		respond(MongoUtils.toJsonString(new SuccessResult<Object>(message, data)))
				.contentType("application/json;charset=utf-8").status(200);
	}

	/**
	 * 后端接口回调规范
	 */
	public void success(Object data) {
		respond(MongoUtils.toJsonString(new SuccessResult<Object>(data))).contentType("application/json;charset=utf-8")
				.status(200);
	}

}

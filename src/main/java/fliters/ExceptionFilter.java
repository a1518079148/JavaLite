package fliters;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;
import org.javalite.common.JsonHelper;

import com.ac.exception.RException;
import com.ac.response.FailureResult;
import com.ac.response.Status;

/*
 * 异常抛出监听
 */
public class ExceptionFilter extends HttpSupportFilter {
	@Override
	public void onException(Exception e) {
		if(e.getClass().equals(RException.class)) {
			RException re = (RException)e;
			res(new FailureResult<>(re.getStatus(), re.getMessage()));
			
		} else {
			e.printStackTrace();
			res(new FailureResult<>(Status.ERROR, "未知错误"));
			return;
		}
	}
	
	private void res(Object object) {
		String json = JsonHelper.toJsonString(object);
		respond(json).contentType("application/json;charset=UTF-8");
	}
}

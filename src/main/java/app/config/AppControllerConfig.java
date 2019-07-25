package app.config;

import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;

import fliters.ExceptionFilter;
import fliters.UserFilter;

/**
 * 
 * @title 添加过滤器目标
 * @author CYC
 */
@SuppressWarnings({"rawtypes"})
public class AppControllerConfig extends AbstractControllerConfig {

	public void init(AppContext context) {
    	/**
    	E:
    	//过滤该控制器下的所有api
		add(new XFilter()).to(XController.class);
		//不过滤此api，其他均过滤，添加多条使用,隔开
		add(new XFilter()).to(XController.class).excludeActions("query");
		//只过滤此api，其他均不过滤，添加多条使用,隔开
		add(new XFilter()).to(XController.class).forActions("insert");
    	 * 
    	 */
    	add(new UserFilter());
    	add(new ExceptionFilter());
    	/**
    	 * 请求/admin时需要验证是否登录
    	 */
//    	add(new LoginFilter()).to(AdminController.class);
    }
}

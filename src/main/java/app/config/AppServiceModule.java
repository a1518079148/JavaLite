package app.config;

import java.util.Set;

import org.javalite.activeweb.Configuration;

import com.ac.support.ClassUtils;
import com.google.inject.AbstractModule;

/**
 * 应用程序服务绑定模块
 * 
 * @author CYC
 */
public class AppServiceModule extends AbstractModule {
	/**
	 * 配置定义
	 * 
	 * <p>
	 * 可以一次性定义多个服务绑定信息，一条绑定为一行。
	 * </p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void configure() {
		Set<Class<?>> serviceimpls = ClassUtils.getClzFromPkg(Configuration.get("bind_pageage"));
		for (Class class_impl : serviceimpls) {
			try {
				String class_service_name = class_impl.getName().replace(".impl", "").replace("ServiceImpl", "Service");
				Class class_service = Class.forName(class_service_name);
				bind(class_impl).to(class_service);
			} catch (ClassNotFoundException e) {
				// stop
			}
		}
	}

}

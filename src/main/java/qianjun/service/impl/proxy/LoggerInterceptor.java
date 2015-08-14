package qianjun.service.impl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * 动态代理 在target的某个方法前干点别的事情
 * @author QianJun
 *
 */
public class LoggerInterceptor implements InvocationHandler {
	
	private Logger LOG = Logger.getLogger(LoggerInterceptor.class);
	
	private Object target;
	
	
	public Object getTarget() {
		return target;
	}


	public void setTarget(Object target) {
		this.target = target;
	}


	public void before(Method method){
		LOG.info(method.getName() + " start...");
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before(method);
		Object obj = method.invoke(target, args); //要返回！！！
		return obj;
	}

}

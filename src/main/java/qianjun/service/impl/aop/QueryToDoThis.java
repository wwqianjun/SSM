package qianjun.service.impl.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class QueryToDoThis {
	
	private Logger LOG = LoggerFactory.getLogger(QueryToDoThis.class);

	@Pointcut("execution(* qianjun.service.impl.UserService.queryUserById(int)) && args(id)")
	public void query(int id){
		
	}
	@Before("query(id)")
	public void say(JoinPoint joinPoint, int id){
		// 拦截的实体类
		Object target = joinPoint.getTarget();
		// 拦截的方法名称
		String menthodName = joinPoint.getSignature().getName();
		// 拦截的方法参数
		Object[] args = joinPoint.getArgs();
		
		LOG.info("{}(int {})方法开始调用", menthodName,args);
	}
}

package qianjun.servicetest;

import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import qianjun.rdm.model.User;
import qianjun.service.IUserService;
import qianjun.service.impl.UserService;
import qianjun.service.impl.proxy.LoggerInterceptor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class UserServiceTest {

	private static final Logger LOG = Logger.getLogger(UserServiceTest.class);
	@Autowired
	private IUserService userService;

	@Test
	public void testQueryUserById(){
		User user = userService.queryUserById(2);
		//System.out.println(user.getName());
		LOG.debug("用户名{"+user.getName()+"}");
	}
	
	@Test
	public void testGetAllUser(){
		List<User> list = userService.getAllUser();
		LOG.info(JSON.toJSONString(list));
	}
	
	@Test
	public void getAllUserWithRole(){
		List<User> list = userService.getAllUserWithRole();
		LOG.info(JSON.toJSONString(list));
	}
	
	@Test
	public void testProxy(){
		
		User user = userService.queryUserById(2);
		//System.out.println(user.getName());
		LOG.debug("用户名{"+user.getName()+"}");
		
		//自己写的代理在Spring中运行
		IUserService userService2 = new UserService();
		LoggerInterceptor interceptor = new LoggerInterceptor();
		interceptor.setTarget(userService);
		
		IUserService userServiceProxy = (IUserService) Proxy.newProxyInstance(userService2.getClass().getClassLoader(), new Class[]{IUserService.class}, interceptor);
		
		User user1 = userServiceProxy.queryUserById(2);
		System.out.println(user1.getName());
	}
}

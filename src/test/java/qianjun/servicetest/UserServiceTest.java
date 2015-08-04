package qianjun.servicetest;

import java.lang.reflect.Proxy;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import qianjun.common.CommonConstants.SequenceName;
import qianjun.common.CommonException;
import qianjun.rdm.mapper.SequenceMapper;
import qianjun.rdm.model.User;
import qianjun.rdm.util.SequenceGenerator;
import qianjun.service.IUserService;
import qianjun.service.impl.SequenceService;
import qianjun.service.impl.UserService;
import qianjun.service.impl.proxy.LoggerInterceptor;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-bean.xml","classpath:spring-mybatis.xml"})
public class UserServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	private IUserService userService;

	@Autowired
	private SequenceMapper sequenceMapper;
	
	@Test
	public void testQueryUserById(){
		User user = userService.queryUserById(2);
//		System.out.println(user.getName());
		LOG.debug("用户名{}",JSON.toJSONString(user));
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
		System.out.println();
		User user = userService.queryUserById(2);
		//System.out.println(user.getName());
//		LOG.debug("用户名{}",user.getName());
		
		//自己写的代理在Spring中运行
		IUserService userService2 = new UserService();
		LoggerInterceptor interceptor = new LoggerInterceptor();
		interceptor.setTarget(userService);
		
		IUserService userServiceProxy = (IUserService) Proxy.newProxyInstance(userService2.getClass().getClassLoader(), new Class[]{IUserService.class}, interceptor);
		
		User user1 = userServiceProxy.queryUserById(2);
		System.out.println(user1.getName());
	}
	
	@Test
	public void add() throws CommonException{
		User user = new User();

		user.setId(Integer.parseInt( SequenceGenerator.getNextSeq(SequenceName.USER_ID.getValue()) ) );
		user.setName("杀千刀");
		user.setPassword("baizihua");
		int row = userService.addUser(user);
		
		LOG.info("{} rows affected ",row);
	}
//	
//	@Test
//	public void testGetSeqMaxValue() throws CommonException{
//		User user = new User();
//		System.out.println();
//		System.out.println();
//		String value = SequenceName.USER_ID.getValue();
//		System.out.println("getNextSeqWithDate:"+sequenceMapper.getSeqMaxValue(value));
////		System.out.println();
////		user.setId(Integer.parseInt( SequenceGenerator.getNextSeqWithDate(SequenceName.USER_ID.getValue()) ) );
////		user.setName("杀千刀");
////		user.setPassword("baizihua");
////		int row = userService.addUser(user);
////		
////		LOG.info("{} rows affected ",row);
//	}
}

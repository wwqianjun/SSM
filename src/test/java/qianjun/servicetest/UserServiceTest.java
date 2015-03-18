package qianjun.servicetest;

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
}

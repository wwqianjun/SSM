package qianjun.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import qianjun.rdm.model.User;
import qianjun.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void testQueryUserById(){
		User user = userService.queryUserById(2);
		System.out.println(user.getName());
	}
}

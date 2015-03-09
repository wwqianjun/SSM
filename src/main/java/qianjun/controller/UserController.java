package qianjun.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import qianjun.rdm.model.User;
import qianjun.service.IUserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private IUserService userSerive;
	
	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{

		User user = userSerive.queryUserById(Integer.parseInt(id));
		System.out.println(user.getName());
		request.setAttribute("user",  user);

		return "showUser";
	}
	
	@RequestMapping("/add")
	public void addUser(HttpServletRequest request) throws UnsupportedEncodingException{
		User user = new User();
		user.setName("张三");
		user.setPassword("123456");
		
		userSerive.addUser(user);
	}
}

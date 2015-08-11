package qianjun.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qianjun.common.AjaxResponse;
import qianjun.common.ControllerUtils;
import qianjun.rdm.model.User;
import qianjun.service.IUserService;
import qianjun.service.dto.WangQiQiDTO;

@Controller
//@RequestMapping("/userController")
public class UserController {

	private static final Logger LOG = Logger.getLogger(UserController.class);
	/**
	 * @Resource 同时支持ByName和ByType匹配
	 * @Autowired 支持ByType支持，所以有requried属性是否必须 @Qualifier
	 */
	@Autowired
	private IUserService userSerive;

	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		User user = userSerive.queryUserById(Integer.parseInt(id));
		System.out.println(user.getName());
		request.setAttribute("user", user);

		return "ftl/showUser";
	}

	@RequestMapping("/add")
	public void addUser(HttpServletRequest request)
			throws UnsupportedEncodingException {
		User user = new User();
		user.setName("张三");
		user.setPassword("123456");

		userSerive.addUser(user);
	}
	
	//==========================================================
	//  Ajax之旅
	//==========================================================
	//返回对象
	@RequestMapping("unSyn")
	@ResponseBody
	public AjaxResponse unSyn(){
		WangQiQiDTO obj = new WangQiQiDTO("王琪琪",20);
		 
		List<WangQiQiDTO> girls = new ArrayList<WangQiQiDTO>();
		obj.setGirls(girls);
		return ControllerUtils.returnAjaxSuccessResponseWithData(obj);
	}
	
	// 返回String
	@RequestMapping("unSynString")
	@ResponseBody
	public String unSynString(String value){
		 
		return value;
	}
	// 返回int
	@RequestMapping("unSynInt")
	@ResponseBody
	public int unSynInt(int value){
		 
		return value;
	}
	
	
	//==========================================================
	@RequestMapping(value = { "/index", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
 
	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("ftl/hello");
	  return model;
 
	}
 
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
	  LOG.info("/admin 开始登陆！");
	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("ftl/admin");
	  return model;
 
	}
 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("ftl/login");
 
	  return model;
 
	}
 
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
 
	  ModelAndView model = new ModelAndView();
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("ftl/403");
	  return model;
 
	}
}

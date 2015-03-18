package qianjun.service;

import java.util.List;

import qianjun.rdm.model.User;

public interface IUserService {

	/**
	 * 通过用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);

	public int addUser(User user);
	
	public List<User> getAllUser();
	
	/**
	 * 查询所有用户，并显示他的角色信息
	 * @return
	 */
	public List<User> getAllUserWithRole();
	
}

package qianjun.service;

import qianjun.rdm.model.User;

public interface IUserService {

	/**
	 * 通过用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);

	public int addUser(User user);
}

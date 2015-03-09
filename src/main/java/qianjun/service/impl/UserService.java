package qianjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qianjun.rdm.dao.UserMapper;
import qianjun.rdm.model.User;
import qianjun.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public User queryUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int addUser(User user) {
		return userMapper.insert(user);
	}

}

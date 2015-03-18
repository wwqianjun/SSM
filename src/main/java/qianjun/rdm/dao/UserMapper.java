package qianjun.rdm.dao;

import java.util.List;

import qianjun.rdm.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //------------自定义查询-----------------------
    /**
     * 
     * @return
     */
    List<User> getAllUser();
    
    List<User> getAllUserWithRole();
}
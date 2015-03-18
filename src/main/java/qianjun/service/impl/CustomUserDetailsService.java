package qianjun.service.impl;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import qianjun.rdm.model.DbUser;

/** 
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService 
 *  
 * @author QianJun 
 *  
 */  
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {  
  
    protected static Logger logger = Logger.getLogger(CustomUserDetailsService.class);  
  
//    private UserDao userDAO = new UserDao();  
    @Resource
    private UserDao userDAO;  
  
    public UserDetails loadUserByUsername(String j_username)  
            throws UsernameNotFoundException, DataAccessException {  
  
        UserDetails user = null;  
  
        try {  
  
            // 搜索数据库以匹配用户登录名.  
            // 我们可以通过dao使用JDBC来访问数据库  
            DbUser dbUser = userDAO.getDatabase(j_username);  
  
            // Populate the Spring User object with details from the dbUser  
            // Here we just pass the username, password, and access level  
            // getAuthorities() will translate the access level to the correct  
            // role type  
  
            user = new User(dbUser.getUsername(), dbUser.getPassword()
            		, true, true, true, true,  
                    getAuthorities(dbUser.getAccess()));  
            logger.info("授权成功！");
        } catch (Exception e) {  
            logger.error("Error in retrieving user");  
            throw new UsernameNotFoundException("Error in retrieving user");  
        }  
  
        return user;  
    }  
  
    /** 
     * 获得访问角色权限 
     *  
     * @param access 
     * @return 
     */  
    @SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(Integer access) {  
  
        Collection<GrantedAuthority> authSet = new HashSet<GrantedAuthority>(2);  
  
        // 所有的用户默认拥有ROLE_USER权限  
        logger.debug("Grant ROLE_USER to this user");  
        authSet.add(new GrantedAuthorityImpl("ROLE_USER"));  
  
        // 如果参数access为1.则拥有ROLE_ADMIN权限  
        if (access.compareTo(1) == 0) {  
            logger.debug("Grant ROLE_ADMIN to this user");  
            authSet.add(new GrantedAuthorityImpl("ROLE_ADMIN"));  
        }  
  
        return authSet;  
    }  
}  

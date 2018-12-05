package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.UserInfoDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional//开启事务
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 添加用户
     * @param userInfo
     */
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoDao.saveUserInfo(userInfo);
    }

    /**
     * 查询所有用户列表
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = userInfoDao.findAll();
        return userInfoList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        System.out.println("=====================");
        System.out.println(userInfo);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true, true, authoritys);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList<>();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;

    }
}

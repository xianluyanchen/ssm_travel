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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional//开启事务
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 添加用户
     *
     * @param userInfo
     */
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        String password = userInfo.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        userInfo.setPassword(encodePassword);
        userInfoDao.saveUserInfo(userInfo);
    }

    /**
     * 给用户添加角色信息
     *
     * @param userId
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        if (roleIds != null) {
            for (int i = 0; i < roleIds.length; i++) {

                userInfoDao.addRoleToUser(userId, roleIds[i]);
            }
        }


    }

    /**
     * cha查找用户不具备的角色
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo findUserByIdAndAllRole(String userId) {
        UserInfo userByIdAndAllRole = userInfoDao.findUserByIdAndAllRole(userId);
        return userByIdAndAllRole;
    }

    /**
     * t通过user的id查询user的信息
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo findById(String userId) {
        UserInfo userInfo = userInfoDao.findById(userId);
        return userInfo;
    }

    /**
     * 查询所有用户列表
     *
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = userInfoDao.findAll();
        return userInfoList;
    }

    /**
     * 校验用户/认证权限
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
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
            authoritys.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authoritys;

    }
}

package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService extends UserDetailsService {

    /**
     * cha查询所有用户
     * @return
     */
    List<UserInfo> findAll();

    /**
     * save the users
     * @param userInfo
     */
    void saveUserInfo(UserInfo userInfo);

    /**
     * find user by USerID
     *
     * @param userId
     * @return
     */
    UserInfo findById(String userId);
}

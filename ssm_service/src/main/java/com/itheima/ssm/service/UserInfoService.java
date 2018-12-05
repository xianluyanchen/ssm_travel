package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserInfoService extends UserDetailsService {

    List<UserInfo> findAll();

    void saveUserInfo(UserInfo userInfo);
}

package com.itheima.ssm.controller;

import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/save")
    public void saveUserInfo(UserInfo userInfo) {
        userInfoService.saveUserInfo(userInfo);
    }

    /**
     * yongh用户管理页面，查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userInfoService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }
}

package com.itheima.ssm.controller;

import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name="userId",required = true) String userId,@RequestParam(name="ids",required = true) String[] roleIds) {
        userInfoService.addRoleToUser(userId, roleIds);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true) String userId) {
        System.out.println(userId);
        UserInfo userInfoList = userInfoService.findUserByIdAndAllRole(userId);
        System.out.println(userInfoList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfoList);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String userId) {

        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findById(userId);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }


    /**
     * yonghu用户添加
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public String saveUserInfo(UserInfo userInfo) {
        userInfoService.saveUserInfo(userInfo);
        return "redirect:/user/findAll";
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

package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserInfoDao {

    /**
     * 用户登录，权限验证
     * @param username
     * @return
     */
    @Select("select * from users where username=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",javaType=List.class,many=@Many(
                    select = "com.itheima.ssm.dao.RoleDao.findRoleByUserId"
            ))
    })
    UserInfo findByUsername(String username);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUserInfo(UserInfo userInfo);
}

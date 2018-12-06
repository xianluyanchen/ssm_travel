package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    /**
     * 根据userID查询role的信息
     * @param uid
     * @return
     */
    @Select("select * from role where id in (select roleId from user_role where userId = #{userId})")
    @Results(
            {@Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.itheima.ssm.dao.PermissionDao.findByRoleId"))
            }
    )
    List<Role> findRoleByUserId(String uid);

    /**
     * 查询所有的role信息
     */
    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);
}

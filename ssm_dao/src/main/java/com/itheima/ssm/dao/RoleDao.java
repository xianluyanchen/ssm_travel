package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from user_role where userId = #{userId})")
    List<Role> findRoleByUserId(String uid);

}

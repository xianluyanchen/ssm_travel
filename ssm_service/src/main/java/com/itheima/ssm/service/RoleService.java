package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {


    List<Role> findAll();

    void save(Role role);
}

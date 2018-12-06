package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }
}

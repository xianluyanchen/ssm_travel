package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> findOtherPermission(String roleid) {
        List<Permission> permissionList = permissionDao.findOtherPermission(roleid);
        return permissionList;
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);

    }

    @Override
    public List<Permission> findAll() {

        List<Permission> permissionList = permissionDao.findAll();
        return permissionList;
    }
}

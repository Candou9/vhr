package org.jx.vhr.service;

import org.jx.vhr.mapper.RoleMapper;
import org.jx.vhr.model.Menu;
import org.jx.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if(!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

}

package org.jx.vhr.service;

import org.jx.vhr.mapper.MenuMapper;
import org.jx.vhr.mapper.MenuRoleMapper;
import org.jx.vhr.model.Hr;
import org.jx.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getMenuByHrId() {
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

 //   @Cacheable
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteById(rid);
        Integer result=menuRoleMapper.insertRecord(rid,mids);
        return result==mids.length;

    }
}

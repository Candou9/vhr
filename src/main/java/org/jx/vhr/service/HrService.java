package org.jx.vhr.service;

import org.jx.vhr.entity.Hr;
import org.jx.vhr.mapper.HrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class HrService implements UserDetailsService {
    @Autowired
    HrDao hrDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr= hrDao.loadUserByUsername(s);
        if(hr==null){
            throw new UsernameNotFoundException("User name not exists!");
        }
        return hr;
    }
}

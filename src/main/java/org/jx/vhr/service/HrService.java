package org.jx.vhr.service;

import org.jx.vhr.model.Hr;
import org.jx.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr= hrMapper.loadUserByUsername(s);
        if(hr==null){
            throw new UsernameNotFoundException("User name not exists!");
        }
        return hr;
    }
}

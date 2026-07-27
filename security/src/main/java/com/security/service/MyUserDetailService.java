package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.repository.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService  {

    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder en=new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByUsername(username);
        if(user==null){
            System.out.print("UserNotFound");
            throw new UsernameNotFoundException("user not found");
        }else{
            return new UserPrincipal(user);
        }
    }

    public User findUser(String username){
        return repo.findByUsername(username);
    }

    public User register(User user){
        user.setPassword(en.encode(user.getPassword()));
        return repo.save(user);
    }
}

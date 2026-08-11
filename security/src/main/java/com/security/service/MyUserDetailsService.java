package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.model.Users;
import com.security.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder en=new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=repo.findByUsername(username);
        if (user==null) {
            System.out.print("User Not Found");
            throw new UsernameNotFoundException("UserNotFound");
        }
        return new UserPrincipal(user);
    }

    public Users register(Users users){
        users.setPassword(en.encode(users.getPassword()));
        return repo.save(users);
    }

}

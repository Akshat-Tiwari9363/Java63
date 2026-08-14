package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.model.Users;
import com.jwt.repository.UserRepo;

@Service
public class MyUsersDetailService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder en=new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=repo.findByUsername(username);
        if(users==null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User does not exist");
        }
        return new UserPrincipal(users);
    }

    public Users register(Users users){
        users.setPassword(en.encode(users.getPassword()));
        return repo.save(users);
    }

    public List<String> findAllUsername(){
        return repo.findAllUsernameList();
    }

}

package com.telusko.JobApp.service;


import com.dao.UserRepo;
import com.telusko.JobApp.model.User;
import com.telusko.JobApp.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
   private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = repo.findByUsername(username);
        if (byUserName==null){
            System.out.println("err 404 usersss not found");
            throw new UsernameNotFoundException("usr 404 exc");

        }
        return new UserPrincipal(byUserName);
    }
}

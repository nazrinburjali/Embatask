package com.embatask.productmanagement.security;

import com.embatask.productmanagement.domain.User;
import com.embatask.productmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal userPrincipal = null;
        Optional<User>optionalUser = Optional.ofNullable(userService.getUserByEmail(username));
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userPrincipal = new UserPrincipal(user);

        }else{
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return userPrincipal;
    }
}

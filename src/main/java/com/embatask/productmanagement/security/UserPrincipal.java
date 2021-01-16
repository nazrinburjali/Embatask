package com.embatask.productmanagement.security;

import com.embatask.productmanagement.domain.Role;
import com.embatask.productmanagement.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User user;

    public User getUser() {
        return user;
    }

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = user.getRoles();
        roles.forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    @Override
//    public boolean isAccountNonLocked() {
//        return user.getUserStatus() != UserStatus.DELETED;
//    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


//    @Override
//    public boolean isEnabled() {
//        return user.getUserStatus() == UserStatus.ACTIVE;
//    }
}

package com.CoffeeVending.CoffeeVendingShop.Config;

import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private UsersEntity usersEntity;

    public UserDetails(UsersEntity user) {
        this.usersEntity=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() {
        if(usersEntity != null) {
            return usersEntity.getPassword();
        }
        return null;
    }

    @Override
    public String getUsername() {
        if(usersEntity!=null) {
            return usersEntity.getUsername();
        }
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
return true;    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

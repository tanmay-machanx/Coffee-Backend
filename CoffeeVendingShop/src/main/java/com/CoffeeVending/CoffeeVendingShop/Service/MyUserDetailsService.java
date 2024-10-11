package com.CoffeeVending.CoffeeVendingShop.Service;

import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import com.CoffeeVending.CoffeeVendingShop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user=userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
        }
        return new com.CoffeeVending.CoffeeVendingShop.Config.UserDetails(user) {
        };
    }
}

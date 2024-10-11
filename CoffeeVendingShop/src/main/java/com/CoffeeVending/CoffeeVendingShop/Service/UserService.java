package com.CoffeeVending.CoffeeVendingShop.Service;

import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import com.CoffeeVending.CoffeeVendingShop.Repository.UserRepository;
import org.apache.catalina.User;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private com.CoffeeVending.CoffeeVendingShop.Repository.UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public String ValidateUser(UsersEntity userData){
            return verify(userData);
    }

    public Optional<UsersEntity> CreateUser(UsersEntity newUser){
        Optional<UsersEntity> fetchedUser=userRepository.findById(newUser.getUsername());
        if(fetchedUser.isEmpty()){
            newUser.setPassword(encoder.encode(newUser.getPassword()));
            userRepository.save(newUser);
            return Optional.of(newUser);
        }
        return Optional.empty();
    }

    public String verify(UsersEntity user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}
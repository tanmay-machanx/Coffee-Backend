package com.CoffeeVending.CoffeeVendingShop.Controller;


import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import com.CoffeeVending.CoffeeVendingShop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//import com.CoffeeVending.CoffeeVendingShop.Service*;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private com.CoffeeVending.CoffeeVendingShop.Service.UserService userService;



    @GetMapping
    public String test() {
        return "ok";
    }

    @PostMapping("/login")
    public String fetchUser(@RequestBody UsersEntity comingUser) {
        String user = userService.ValidateUser(comingUser);
            return userService.verify(comingUser);
    }

    @PostMapping("/signup")
    public ResponseEntity<Optional<UsersEntity>> createUser(@RequestBody UsersEntity newUser) {
        Optional<UsersEntity> createdUser = userService.CreateUser(newUser);  // Assuming this method exists in your service
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}


package com.CoffeeVending.CoffeeVendingShop.Repository;


import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity,String> {
    UsersEntity findByUsername(String username);
}

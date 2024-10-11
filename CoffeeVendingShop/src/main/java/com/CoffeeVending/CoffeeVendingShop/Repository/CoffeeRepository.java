package com.CoffeeVending.CoffeeVendingShop.Repository;

import com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity;
import com.CoffeeVending.CoffeeVendingShop.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CoffeeRepository extends JpaRepository<CoffeeAppEntity,String> {
}



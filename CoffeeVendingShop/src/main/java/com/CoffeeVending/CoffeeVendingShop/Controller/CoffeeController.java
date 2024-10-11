package com.CoffeeVending.CoffeeVendingShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Coffee")
public class CoffeeController {

    private final Map<String, com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity> coffeeAppObject = new HashMap<>();
    @Autowired
    private com.CoffeeVending.CoffeeVendingShop.Service.CoffeeOrderService coffeeOrderService;
    @GetMapping("/test")
    public String test() {
        return "API_Working";
    }

    @GetMapping
    public List<com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity> fetchOrders() {
        System.out.println("Get Coffee call");
        return coffeeOrderService.getAllEntries();
    }
    @PostMapping
    public boolean CreateEntry(@RequestBody com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity RequestData) {
        return coffeeOrderService.saveEntry(RequestData);
    }
    @GetMapping("id/{id}")
    public Optional<com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity> GetOrderById(@PathVariable String id) {
        return coffeeOrderService.getEntryById(id);
    }
    @DeleteMapping("id/{id}")
    public Optional<com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity> DeleteOrderById(@PathVariable String id) {
        return coffeeOrderService.removeEntry(id);
    }

    @PutMapping("id/{id}")
    public com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity UpdateOrderById(@PathVariable String id, @RequestBody com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity RequestData) {
        return coffeeOrderService.updateOrder(id,RequestData);
    }
}
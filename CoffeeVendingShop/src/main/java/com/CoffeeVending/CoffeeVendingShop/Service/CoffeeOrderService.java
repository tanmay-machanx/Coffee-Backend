package com.CoffeeVending.CoffeeVendingShop.Service;

import com.CoffeeVending.CoffeeVendingShop.Entity.CoffeeAppEntity;
import com.CoffeeVending.CoffeeVendingShop.Repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    // Get all entries
    public List<CoffeeAppEntity> getAllEntries() {
        return coffeeRepository.findAll();
    }

    // Get entry by ID
    public Optional<CoffeeAppEntity> getEntryById(String id) {
        return coffeeRepository.findById(id);
    }


    public boolean saveEntry(CoffeeAppEntity requestData) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        requestData.setCreateTime(currentTime.toString());
        requestData.setCreateDate(currentDate.toString());
        coffeeRepository.save(requestData);
        return true;
    }

    public Optional<CoffeeAppEntity> removeEntry(String id) {
        if (coffeeRepository.existsById(id)) {
            Optional<CoffeeAppEntity> item = coffeeRepository.findById(id);
            coffeeRepository.deleteById(id);
            return item;
        }
        return Optional.empty();
    }

    // Update order by ID
    public CoffeeAppEntity updateOrder(String id, CoffeeAppEntity updatedData) {
        Optional<CoffeeAppEntity> orderOptional = coffeeRepository.findById(id);

        if (orderOptional.isPresent()) {
            CoffeeAppEntity existingOrder = (CoffeeAppEntity) orderOptional.get();
            existingOrder.setTitle(updatedData.getTitle());
            existingOrder.setDescription(updatedData.getDescription());
            existingOrder.setPriority(updatedData.getPriority());
            existingOrder.setAmount(updatedData.getAmount());
            existingOrder.setStatus(updatedData.getStatus());
            return coffeeRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found with id: " + id);
        }
    }
}

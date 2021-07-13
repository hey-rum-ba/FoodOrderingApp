package com.finartz.restaurantapp.controller;

import com.finartz.restaurantapp.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket/")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping("create")
    public ResponseEntity<Basket> create(@RequestBody Basket basket){
        return new ResponseEntity<>(basketService.create(basket), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Basket> update(@RequestBody Basket basket){
        return new ResponseEntity<>(basketService.update(basket), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Basket> get(@PathVariable Long id){
        return new ResponseEntity<>(basketService.getById(id), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Basket>> getAll(){
        return new ResponseEntity<>(basketService.getAll(), HttpStatus.OK)
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        basketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

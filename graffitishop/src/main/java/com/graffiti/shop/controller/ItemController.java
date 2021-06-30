package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Item;
import com.graffiti.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> showAllItems(){
        return itemService.getAllItems();
    }

    //need exc
    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable int id) {
        return itemService.getItem(id);
    }

    @PostMapping("/items")
    public Item addNewItem(@RequestBody Item item) {
        itemService.saveItem(item);
        return item;
    }

    @PutMapping("/items")
    public Item updateItem(@RequestBody Item item) {
        itemService.saveItem(item);
        return item;
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "Item with ID = " + id + " was deleted";
    }
}

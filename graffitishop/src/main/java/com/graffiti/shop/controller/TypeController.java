package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Type;
import com.graffiti.shop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public List<Type> showAllTypes() {
        return typeService.getAllTypes();
    }

    //need exc
    @GetMapping("/types/{id}")
    public Type getType(@PathVariable int id) {
        return typeService.getType(id);
    }

    @PostMapping("/types")
    public Type addNewType(@RequestBody Type type) {
        typeService.saveType(type);
        return type;
    }

    @PutMapping("/types")
    public Type updateType(@RequestBody Type type) {
        typeService.saveType(type);
        return type;
    }

    @DeleteMapping("/types/{id}")
    public String deleteType(@PathVariable int id) {
        typeService.deleteType(id);
        return "Type with ID = " + id + " was deleted";
    }
}

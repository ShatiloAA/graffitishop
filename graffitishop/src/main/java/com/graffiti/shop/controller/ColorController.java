package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Color;
import com.graffiti.shop.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("/colors")
    public List<Color> showAllColors(){
        return colorService.getAllColors();
    }

    //need exc
    @GetMapping("/colors/{id}")
    public Color getColor(@PathVariable int id) {
        return colorService.getColor(id);
    }

    @PostMapping("/colors")
    public Color addNewColor(@RequestBody Color color) {
        colorService.saveColor(color);
        return color;
    }

    @PutMapping("/colors")
    public Color updateColor(@RequestBody Color color){
        colorService.saveColor(color);
        return color;
    }

    @DeleteMapping("/colors/{id}")
    public String deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
        return "Color with ID = " + id + " was deleted";
    }
}

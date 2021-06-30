package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Brand;
import com.graffiti.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> showAllbrands(){
        return brandService.getAllBrands();
    }

    //need exc
    @GetMapping("/brands/{id}")
    public Brand getBrand(@PathVariable int id) {
        return brandService.getBrand(id);
    }

    @PostMapping("/brands")
    public Brand addNewBrand(@RequestBody Brand brand) {
        brandService.saveBrand(brand);
        return brand;
    }

    @PutMapping("/brands")
    public Brand updateBrand(@RequestBody Brand brand){
        brandService.saveBrand(brand);
        return brand;
    }

    @DeleteMapping("/brands/{id}")
    public String deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
        return "Brand with ID = " + id + " was deleted";
    }
}

package com.graffiti.shop.service;

import com.graffiti.shop.domain.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();

    Brand saveBrand(Brand brand);

    Brand getBrand(int id);

    void deleteBrand(int id);
}

package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Brand;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.BrandRepository;
import com.graffiti.shop.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        logger.info("getAllBrands() entered");
        return brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        logger.info("saveColor() entered with Entity = " + brand.toString());
        try {
            brand = brandRepository.save(brand);
            logger.info("Successfully created Brand with id = " + brand.getId());
            return brand;
        } catch (Exception e) {
            logger.error("Exception occurred while creating Brand: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Brand getBrand(int id) {
        logger.info("getBrand() entered with id = " + id);
        Optional<Brand> optional = brandRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteBrand(int id) {
        logger.info("deleteBrand() deleted with id = " + id);
        try {
            brandRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Brand");
            throw new RuntimeException(e);
        }
    }
}

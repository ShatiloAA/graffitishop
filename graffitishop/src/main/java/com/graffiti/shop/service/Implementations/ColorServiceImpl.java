package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Color;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.ColorRepository;
import com.graffiti.shop.service.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    Logger logger = LoggerFactory.getLogger(ColorServiceImpl.class);
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAllColors() {
        logger.info("getAllColors() entered");
        return colorRepository.findAll();
    }

    @Override
    public Color saveColor(Color color) {
        logger.info("saveColor() entered with Entity = " + color.toString());
        try {
            color = colorRepository.save(color);
            logger.info("Successfully created Color with id = " + color.getId());
            return color;
        } catch (Exception e) {
            logger.error("Exception occurred while creating Color: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Color getColor(int id) {
        logger.info("getColor() entered with id = " + id);
        Optional<Color> optional = colorRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteColor(int id) {
        logger.info("deleteColor() deleted with id = " + id);
        try {
            colorRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Color");
            throw new RuntimeException(e);
        }
    }
}

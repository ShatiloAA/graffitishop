package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Type;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.TypeRepository;
import com.graffiti.shop.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypes() {
        logger.info("getAllTypes() entered");
        return typeRepository.findAll();
    }

    @Override
    public Type saveType(Type type) {
        logger.info("saveType() entered with Entity = " + type.toString());
        typeRepository.save(type);
        try {
            type = typeRepository.save(type);
            logger.info("Successfully created Order with id = " + type.getId());
            return type;
        } catch (Exception e) {
            logger.error("Exception occurred while creating type: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Type getType(int id) {
        logger.info("getType() entered with id = " + id);
        Optional<Type> optional = typeRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteType(int id) {
        logger.info("deleteOrder() deleted with id = " + id);
        try {
            typeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Type");
            throw new RuntimeException(e);
        }
    }
}

package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Item;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.ItemRepository;
import com.graffiti.shop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        logger.info("getAllItems() entered");
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        logger.info("saveItem() entered with Entity = " + item.toString());
        try {
            item = itemRepository.save(item);
            logger.info("Successfully created Item with id = " + item.getId());
            return item;
        } catch (Exception e) {
            logger.error("Exception occurred while creating Item: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item getItem(int id) {
        logger.info("getItem() entered with id = " + id);
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteItem(int id) {
        logger.info("deleteItem() deleted with id = " + id);
        try {
            itemRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Item");
            throw new RuntimeException(e);
        }
    }
}

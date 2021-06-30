package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.OrderItem;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.OrderItemsRepository;
import com.graffiti.shop.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    Logger logger = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    @Autowired
    private OrderItemsRepository orderItemsRepository;


    @Override
    public List<OrderItem> getAllOrderItems() {
        logger.info("getAllOrderItems() entered");
        return orderItemsRepository.findAll();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        logger.info("saveOrderItem() entered with Entity = " + orderItem.toString());
        try {
            orderItem = orderItemsRepository.save(orderItem);
            logger.info("Successfully created OrderItem with id = " + orderItem.getId());
            return orderItem;
        } catch (Exception e) {
            logger.error("Exception occurred while creating OrderItem: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderItem getOrderItem(int id) {
        logger.info("getOrderItem() entered with id = " + id);
        Optional<OrderItem> optional = orderItemsRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteOrderItem(int id) {
        logger.info("deleteOrderItem() deleted with id = " + id);
        try {
            orderItemsRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting OrderItem");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderItem> getAllByOrderId(int id) {
        logger.info("getAllByOrderId() entered");
        return orderItemsRepository.getAllByOrderId(id);
    }

    @Override
    public void deleteOrderItemByOrderId(int id) {
        logger.info("deleteOrderItemByOrderId() deleted with id = " + id);
        try {
            orderItemsRepository.deleteOrderItemsByOrderId(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting OrderItem");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderItemByItemId(int id) {
        logger.info("deleteOrderItemByItemId() deleted with id = " + id);
        try {
            orderItemsRepository.deleteOrderItemByItemId(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting OrderItem");
            throw new RuntimeException(e);
        }
    }
}

package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Order;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.OrderRepository;
import com.graffiti.shop.service.OrderService;
import io.micrometer.core.annotation.Counted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        logger.info("getAllOrders() entered");
        return orderRepository.findAll();
    }

    @Override
    @Counted(value = "save.Order.count",
            description = "Total number of requests of calls saveOrder")
    public Order saveOrder(Order order) {

        logger.info("saveOrder() entered with Entity = " + order.toString());
        try {
            order = orderRepository.save(order);
            logger.info("Successfully created Order with id = " + order.getId());
            return order;
        } catch (Exception e) {
            logger.error("Exception occurred while creating Order: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order getOrder(int id) {
        logger.info("getOrder() entered with id = " + id);
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteOrder(int id) {
        logger.info("deleteOrder() deleted with id = " + id);
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Order");
            throw new RuntimeException(e);
        }
    }
}

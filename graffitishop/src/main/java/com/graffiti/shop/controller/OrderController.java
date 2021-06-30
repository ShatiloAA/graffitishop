package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Order;
import com.graffiti.shop.domain.OrderItem;
import com.graffiti.shop.domain.dto.OrderDTO;
import com.graffiti.shop.kafka.ProducerService;
import com.graffiti.shop.service.OrderItemService;
import com.graffiti.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProducerService producerService;

    @GetMapping("/orders")
    public List<Order> showAllOrders() {
        return orderService.getAllOrders();
    }

    //need exc
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/orders")
    public OrderDTO addNewOrder(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order = orderService.saveOrder(order);
        int orderId = order.getId();
        for (OrderItem item : orderDTO.getItems()) {
            item.setOrderId(orderId);
            orderItemService.saveOrderItem(item);
        }
        orderDTO = new OrderDTO(orderId, order.getCustomerId(),
                orderItemService.getAllByOrderId(orderId));
        producerService.produce(orderDTO);
        return orderDTO;
    }

    @PutMapping("/orders")

    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        int orderId = orderDTO.getOrderId();
        orderItemService.deleteOrderItemByOrderId(orderId);
        for (OrderItem item : orderDTO.getItems()) {
            item.setOrderId(orderId);
            orderItemService.saveOrderItem(item);
        }
        return new OrderDTO(orderId, orderDTO.getCustomerId(),
                orderItemService.getAllByOrderId(orderId));
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order with ID = " + id + " was deleted";
    }

}

package com.graffiti.shop.controller;

import com.graffiti.shop.domain.Order;
import com.graffiti.shop.domain.OrderItem;
import com.graffiti.shop.domain.dto.OrderRequest;
import com.graffiti.shop.domain.dto.OrderResponse;
import com.graffiti.shop.service.OrderItemService;
import com.graffiti.shop.service.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
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

    @GetMapping("/orders")
    public List<Order> showAllOrders(){
        return orderService.getAllOrders();
    }

    //need exc
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/orders")
    public OrderResponse addNewOrder(@RequestBody OrderRequest orderRequest) {
        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order = orderService.saveOrder(order);
        int orderId = order.getId();
        for (OrderItem item : orderRequest.getItems()) {
            item.setOrderId(orderId);
            orderItemService.saveOrderItem(item);
        }
        return new OrderResponse(orderId, order.getCustomerId(),
                orderItemService.getAllByOrderId(orderId));
    }

    @PutMapping("/orders")

    public OrderResponse updateOrder(@RequestBody OrderRequest orderRequest){
        int orderId = orderRequest.getOrderId();
        orderItemService.deleteOrderItemByOrderId(orderId);
        for (OrderItem item : orderRequest.getItems()) {
            item.setOrderId(orderId);
            orderItemService.saveOrderItem(item);
        }
        return new OrderResponse(orderId, orderRequest.getCustomerId(),
                orderItemService.getAllByOrderId(orderId));
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "Order with ID = " + id + " was deleted";
    }

}

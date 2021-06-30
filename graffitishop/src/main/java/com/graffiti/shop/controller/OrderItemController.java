package com.graffiti.shop.controller;

import com.graffiti.shop.domain.OrderItem;
import com.graffiti.shop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graffitishop")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderitems")
    public List<OrderItem> showAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    //need exc
    @GetMapping("/orderitems/{id}")
    public List<OrderItem> getAllByOrderId(@PathVariable int id) {
        return orderItemService.getAllByOrderId(id);
    }

    @PostMapping("/orderitems")
    public OrderItem addNewOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return orderItem;
    }

    @PutMapping("/orderitems")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return orderItem;
    }

    @DeleteMapping("/orderitems/{id}")
    public String deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItemByOrderId(id);
        return "OrderItems with orderID = " + id + " was deleted";
    }

    @DeleteMapping("/orderitems/item/{id}")
    public String deleteItem(@PathVariable int id) {
        orderItemService.deleteOrderItemByItemId(id);
        return "Item with ID = " + id + " was deleted";
    }
}

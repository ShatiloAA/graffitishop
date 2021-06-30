package com.graffiti.shop.service;

import com.graffiti.shop.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order saveOrder(Order Order);

    Order getOrder(int id);

    void deleteOrder(int id);
}

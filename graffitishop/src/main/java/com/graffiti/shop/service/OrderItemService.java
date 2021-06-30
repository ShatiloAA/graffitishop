package com.graffiti.shop.service;

import com.graffiti.shop.domain.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    OrderItem saveOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int id);

    void deleteOrderItem(int id);

    List<OrderItem> getAllByOrderId(int id);

    void deleteOrderItemByOrderId(int id);

    void deleteOrderItemByItemId(int id);
}

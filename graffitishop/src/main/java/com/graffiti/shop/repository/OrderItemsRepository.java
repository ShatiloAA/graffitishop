package com.graffiti.shop.repository;

import com.graffiti.shop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> getAllByOrderId(int id);

    @Transactional
    void deleteOrderItemsByOrderId(int id);

    @Transactional
    void deleteOrderItemByItemId(int id);
}

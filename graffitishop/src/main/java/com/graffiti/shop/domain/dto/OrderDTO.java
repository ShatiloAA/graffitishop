package com.graffiti.shop.domain.dto;

import com.graffiti.shop.domain.Order;
import com.graffiti.shop.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDTO {
    private int orderId;
    private int customerId;
    private List<OrderItem> items;
}

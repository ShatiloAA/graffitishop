package com.graffiti.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;
    //private int price;
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "order_id")
    private int orderId;

   /* @ManyToOne
    @JoinColumn(name = "order", nullable = false)
    private Order order;*/

}

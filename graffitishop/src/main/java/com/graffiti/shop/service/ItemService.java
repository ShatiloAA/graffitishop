package com.graffiti.shop.service;

import com.graffiti.shop.domain.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item saveItem(Item item);

    Item getItem(int id);

    void deleteItem(int id);
}

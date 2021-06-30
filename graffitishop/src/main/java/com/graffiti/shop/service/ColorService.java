package com.graffiti.shop.service;

import com.graffiti.shop.domain.Color;

import java.util.List;

public interface ColorService {

    List<Color> getAllColors();

    Color saveColor(Color color);

    Color getColor(int id);

    void deleteColor(int id);
}

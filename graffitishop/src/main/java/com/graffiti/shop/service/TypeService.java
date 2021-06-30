package com.graffiti.shop.service;

import com.graffiti.shop.domain.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAllTypes();

    Type saveType(Type type);

    Type getType(int id);

    void deleteType(int id);
}

package com.codegym.service;

import com.codegym.model.Item;

import java.util.List;

public interface ItemServiceImpl {
    List<Item> findAll();
    Item findById(int id);
}

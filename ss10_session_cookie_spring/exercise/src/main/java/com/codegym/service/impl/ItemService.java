package com.codegym.service.impl;

import com.codegym.model.Item;
import com.codegym.repository.ItemRepository;
import com.codegym.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService implements ItemServiceImpl {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }
}

package com.project.teem.demo.service.impl;

import com.project.teem.demo.models.Item;
import com.project.teem.demo.repository.ItemRepository;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public long itemCount() {
        return itemRepository.count();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}

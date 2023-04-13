package com.project.teem.demo.service;

import com.project.teem.demo.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    long itemCount();

    Item getItemById(Long id);

    Item saveItem(Item item);

}

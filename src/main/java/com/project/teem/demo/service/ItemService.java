package com.project.teem.demo.service;

import com.project.teem.demo.dto.ItemDto;
import com.project.teem.demo.models.Item;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    long itemCount();

    Item getItemById(Long id);

    Item saveItem(ItemDto itemDto) throws IOException;

    Item updateItem(ItemDto itemDto) throws IOException;

    void deleteItem(Long id);

}

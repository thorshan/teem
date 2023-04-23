package com.project.teem.demo.service.impl;

import com.project.teem.demo.dto.ItemDto;
import com.project.teem.demo.models.Item;
import com.project.teem.demo.repository.ItemRepository;
import com.project.teem.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
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
    public Item saveItem(ItemDto itemDto) throws IOException {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setSize(itemDto.getSize());
        item.setColor(itemDto.getColor());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        item.setCreatedDate(itemDto.getCreatedDate());
        item.setCategory(itemDto.getCategory());
        byte [] photoByte = itemDto.getImage().getBytes();
        String encodedPhoto = Base64.getEncoder().encodeToString(photoByte);
        item.setImage(encodedPhoto);
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(ItemDto itemDto) throws IOException {
        Item item = itemRepository.findById(itemDto.getId()).orElse(null);
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        }

        // Update the item properties
        item.setName(itemDto.getName());
        item.setSize(itemDto.getSize());
        item.setColor(itemDto.getColor());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        item.setCreatedDate(itemDto.getCreatedDate());
        item.setCategory(itemDto.getCategory());

        // Update the image, if necessary
        if (itemDto.getImage() != null && !itemDto.getImage().isEmpty()) {
            byte[] photoBytes = itemDto.getImage().getBytes();
            String encodedPhoto = Base64.getEncoder().encodeToString(photoBytes);
            item.setImage(encodedPhoto);
        }

        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


}

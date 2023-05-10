package com.project.teem.demo.dto;

import com.project.teem.demo.models.Item;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CartDto {

    private Long id;
    private LocalDateTime createdDate;
    private Set<Item> items;
}

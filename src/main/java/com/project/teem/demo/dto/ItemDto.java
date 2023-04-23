package com.project.teem.demo.dto;

import com.project.teem.demo.models.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class ItemDto {

    private Long id;
    private String name;
    private String description;
    private String color;
    private MultipartFile image;
    private String size;
    private String price;
    private LocalDateTime createdDate;
    private Category category;
}

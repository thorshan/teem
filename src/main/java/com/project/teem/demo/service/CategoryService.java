package com.project.teem.demo.service;


import com.project.teem.demo.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category saveCategory(Category category);

    long categoryCount();

}

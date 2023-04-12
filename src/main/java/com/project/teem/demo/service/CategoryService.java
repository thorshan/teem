package com.project.teem.demo.service;


import com.project.teem.demo.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    Category saveCategory(Category category);

    long categoryCount();

    Category getCategoryById(Long id);

    void deleteCategory(Long id);

    Category updateCategory(Category category);

}

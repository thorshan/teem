package com.project.teem.demo.service.impl;

import com.project.teem.demo.models.Category;
import com.project.teem.demo.repository.CategoryRepository;
import com.project.teem.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public long categoryCount() {
        return categoryRepository.count();
    }
}

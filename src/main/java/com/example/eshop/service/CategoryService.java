package com.example.eshop.service;

import com.example.eshop.domain.Category;
import com.example.eshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }
}

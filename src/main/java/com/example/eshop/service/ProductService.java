package com.example.eshop.service;

import com.example.eshop.domain.Product;
import com.example.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public void save(Product p) {
        productRepo.save(p);
    }
}

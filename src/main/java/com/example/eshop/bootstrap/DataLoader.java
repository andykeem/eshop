package com.example.eshop.bootstrap;

import com.example.eshop.domain.Category;
import com.example.eshop.domain.Product;
import com.example.eshop.service.CategoryService;
import com.example.eshop.service.DataImportService;
import com.example.eshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CategoryService catService;

    @Autowired
    private ProductService prodService;

    @Autowired
    private DataImportService dataImportService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {
        log.info("loading db data..");

//        loadCategory();
//        loadProduct();
//        loadProducts();
//        associateNewCategoryWithProducts();
    }

    private void loadCategory() {
    }

    private void loadProduct() {
        Product p = new Product();
        p.setName("White Dress");
        p.setSku("123-456");
        p.setImage("images/womens-white-dress.jpg");
        p.setUrl("/path/to/white-dress.html");
        p.setPrice(324.95);
        prodService.save(p);
    }

    private void loadProducts() {
        String fileName = "data/magento-products.csv";
        Resource resource = new ClassPathResource(fileName);
        File file = null;
        try {
            file = resource.getFile();
            Set<Map<String, String>> data = dataImportService.csvToList(file);
            data.forEach(new Consumer<Map<String, String>>() {
                @Override
                public void accept(Map<String, String> stringStringMap) {
                    log.info("line: " + stringStringMap);
                }
            });
        } catch (IOException e) {

        }
    }

    private void associateNewCategoryWithProducts() {
        Category cat = catService.findByName("New Products");
        prodService.findAll().forEach(new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                product.addCategory(cat);
                prodService.save(product);
            }
        });
    }
}

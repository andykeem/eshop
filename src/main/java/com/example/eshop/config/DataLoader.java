package com.example.eshop.config;

import com.example.eshop.domain.Product;
import com.example.eshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductService prodService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {
        log.info("loading db data..");

        loadCategory();
        loadProduct();

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
}

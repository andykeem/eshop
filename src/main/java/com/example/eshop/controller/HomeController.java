package com.example.eshop.controller;

import com.example.eshop.domain.Category;
import com.example.eshop.domain.Product;
import com.example.eshop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Slf4j
@Controller
public class HomeController {

    private CategoryService catService;

    public HomeController(CategoryService catService) {
        this.catService = catService;
    }

    @ModelAttribute(name = "newProducts")
    public Set<Product> newProducts() {
        Category cat = catService.findByName("New Products");
        Set<Product> prods = cat.getProducts();
        log.info("new products: " + prods);
        return prods;
    }

    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        String title = "Madison Island";
        model.addAttribute("title", title);
        return "home/index";
    }
}

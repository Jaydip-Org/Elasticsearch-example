package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/jpa")
    public List<Product> getAllProductsJpa() {
        return productService.getAllProducts();
    }
	
	@GetMapping("/elasticsearch")
    public List<Product> getAllProductsElasticSearch(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productService.getAllProductsElasticSearch(page, size);
    }

    @GetMapping("/jpa/{id}")
    public Product getProductByIdJpa(@PathVariable Long id) {
        return productService.getProductByIdJpa(id);
    }
    
    @GetMapping("/elasticsearch/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        // Perform any logic related to tax before saving
        if (product.isAddToTax()) {
            double taxPercentage = 5.0;
            product.getSizePriceMap().forEach((size, price) -> {
                double tax = price * taxPercentage;
                product.getSizePriceMap().put(size, price + tax);
            });
        }

         productService.saveProduct(product);
    }

  

}

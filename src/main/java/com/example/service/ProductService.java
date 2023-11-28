package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.elasticsearch.ProductElasticsearchRepository;
import com.example.repository.jpa.ProductJpaRepository;

@Service
public class ProductService {

	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Autowired
	private ProductElasticsearchRepository productElasticsearchRepository;

	public void saveProduct(Product product) {

		productJpaRepository.save(product);
		productElasticsearchRepository.save(product);
	}

	public List<Product> getAllProducts() {

		return productJpaRepository.findAll();
	}

	public List<Product> getAllProductsElasticSearch(int page, int size) {
		
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Product> productPage = productElasticsearchRepository.findAll(pageable);
		return productPage.getContent();
	}

	public Product getProductByIdJpa(Long id) {

		return productJpaRepository.findById(id).orElse(null);
	}

	public Product getProductById(Long id) {

		return productElasticsearchRepository.findById(id).orElse(null);
	}

}

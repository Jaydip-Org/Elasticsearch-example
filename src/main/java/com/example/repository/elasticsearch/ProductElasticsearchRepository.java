package com.example.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.model.Product;

public interface ProductElasticsearchRepository extends ElasticsearchRepository<Product, Long>{

}

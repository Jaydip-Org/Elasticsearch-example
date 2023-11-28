package com.example.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.model.Book;

public interface BookElasticsearchRepository extends ElasticsearchRepository<Book, Long> {

}

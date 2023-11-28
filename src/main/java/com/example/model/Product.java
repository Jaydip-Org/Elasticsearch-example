package com.example.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Entity
@Table(name = "products")
@Document(indexName = "products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@ElementCollection
	@CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
	@MapKeyColumn(name = "size")
	@Column(name = "price")
	private Map<String, Double> sizePriceMap = new HashMap<>();
 
	@Column(name = "addToTax")
	private boolean addToTax;

}

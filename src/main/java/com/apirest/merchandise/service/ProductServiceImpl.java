package com.apirest.merchandise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.merchandise.document.Product;
import com.apirest.merchandise.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository pr;
	
	@Override
	public Flux<Product> findAll() {
		return pr.findAll();
	}

	@Override
	public Mono<Product> findById(String id) {
		return pr.findById(id);
	}

	@Override
	public Mono<Product> save(Product product) {
		return pr.save(product);
	}
	

}

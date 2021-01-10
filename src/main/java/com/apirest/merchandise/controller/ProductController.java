package com.apirest.merchandise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.merchandise.document.Product;
import com.apirest.merchandise.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping(value="/product")
	public Flux<Product> getProducts(){
		return service.findAll();
	}
	
	@GetMapping(value="/product/{id}")
	public Mono<Product> getProductsId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping(value="/product")
	public Mono<Product> save(@RequestBody Product products){
		return service.save(products);
	}
	
	
}

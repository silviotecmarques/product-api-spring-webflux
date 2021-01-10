package com.apirest.merchandise.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.merchandise.document.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}

package com.apirest.merchandise;

import static  org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.apirest.merchandise.document.Product;
import com.apirest.merchandise.service.ProductService;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
	
	@Autowired
	ProductService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(service.findAll(), Product.class);
				
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(service.findById(id), Product.class);
				
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Product> playlist = request.bodyToMono(Product.class);
		return ok()
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMapMany(service::save), Product.class));
			
	}


}

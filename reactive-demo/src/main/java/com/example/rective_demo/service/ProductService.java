package com.example.rective_demo.service;
import com.example.rective_demo.model.Product;
import com.example.rective_demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductService {
private final ProductRepository repo;
public ProductService(ProductRepository repo) {
this.repo = repo;
}
public Flux<Product> getAll() {
return repo.findAll();
}
public Mono<Product> getById(String id) {
return repo.findById(id);
}
}
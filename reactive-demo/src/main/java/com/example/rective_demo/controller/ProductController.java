package com.example.rective_demo.controller;
import com.example.rective_demo.model.Product;
import com.example.rective_demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/products")
public class ProductController {
private final ProductService service;
public ProductController(ProductService service) {
this.service = service;
}
@GetMapping
public Flux<Product> all() {
return service.getAll();
}
@GetMapping("/{id}")
public Mono<ResponseEntity<Product>> one(@PathVariable String id) {
return service.getById(id)
.map(ResponseEntity::ok)
.defaultIfEmpty(ResponseEntity.notFound().build());
}
}
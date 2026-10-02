package com.welisson.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.welisson.course.entities.Product;
import com.welisson.course.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {

    Optional<Product> obj = productRepository.findById(id);

    return obj.get();
  }
}

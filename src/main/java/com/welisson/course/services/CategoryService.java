package com.welisson.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.welisson.course.entities.Category;
import com.welisson.course.repository.CategoryRepository;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) {

    Optional<Category> obj = categoryRepository.findById(id);

    return obj.get();
  }
}

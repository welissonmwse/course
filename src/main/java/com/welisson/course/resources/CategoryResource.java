package com.welisson.course.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welisson.course.entities.Category;
import com.welisson.course.services.CategoryService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  private final CategoryService categoryService;

  public CategoryResource(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> findCategories() {
    List<Category> list = categoryService.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
    Category obj = categoryService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

}

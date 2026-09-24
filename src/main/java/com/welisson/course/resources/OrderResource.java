package com.welisson.course.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welisson.course.entities.Order;
import com.welisson.course.services.OrderService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

  private final OrderService orderService;

  public OrderResource(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity<List<Order>> findOrders() {
    List<Order> list = orderService.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
    Order obj = orderService.findById(id);

    return ResponseEntity.ok().body(obj);
  }

}

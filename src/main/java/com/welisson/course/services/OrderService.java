package com.welisson.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.welisson.course.entities.Order;
import com.welisson.course.repository.OrderRepository;

@Service
public class OrderService {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(Long id) {

    Optional<Order> obj = orderRepository.findById(id);

    return obj.get();
  }
}

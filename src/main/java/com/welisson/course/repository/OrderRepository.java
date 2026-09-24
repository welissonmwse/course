
package com.welisson.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welisson.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

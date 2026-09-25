package com.welisson.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.welisson.course.entities.Category;
import com.welisson.course.entities.Order;
import com.welisson.course.entities.User;
import com.welisson.course.entities.enums.OrderStatus;
import com.welisson.course.repository.CategoryRepository;
import com.welisson.course.repository.OrderRepository;
import com.welisson.course.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;
  private final CategoryRepository categoryRepository;

  public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
      CategoryRepository categoryRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Category cat1 = new Category("Electronics");
    Category cat2 = new Category("Books");
    Category cat3 = new Category("Computers");

    User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

    Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
    Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
    Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));

  }
}

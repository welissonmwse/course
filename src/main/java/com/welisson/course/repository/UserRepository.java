
package com.welisson.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welisson.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

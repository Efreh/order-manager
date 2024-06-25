package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.authN.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByIdGreaterThan(Long id);
}

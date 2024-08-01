package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.authN.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String username);

//    List<User> findByIdGreaterThan(Long id);
}

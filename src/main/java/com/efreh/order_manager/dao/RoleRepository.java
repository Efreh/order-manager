package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.authN.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}

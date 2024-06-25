package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.order.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}

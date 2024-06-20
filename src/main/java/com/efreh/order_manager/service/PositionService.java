package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.PositionRepository;
import com.efreh.order_manager.entity.order.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public boolean savePosition(Position position){
        positionRepository.save(position);
        return true;
    }
}

package com.example.StarbucksRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.StarbucksModel.StarbucksOrder;

@Repository
public interface StarbucksOrderRepository extends JpaRepository<StarbucksOrder, Long> {
    
}
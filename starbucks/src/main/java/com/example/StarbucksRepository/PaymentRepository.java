package com.example.StarbucksRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.StarbucksModel.PaymentModel;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long>{

}
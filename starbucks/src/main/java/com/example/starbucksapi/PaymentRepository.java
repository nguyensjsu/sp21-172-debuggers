package com.example.starbucksapi;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<PaymentModel, Long>{

}
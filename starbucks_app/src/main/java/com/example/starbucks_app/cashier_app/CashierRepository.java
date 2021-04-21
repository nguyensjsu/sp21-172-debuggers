package com.example.starbucks_app;
import org.springframework.data.jpa.repository.JpaRepository;

interface CashierRepository extends JpaRepository<Cashier, Long> {


}
package com.example.StarbucksRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.ExampleMatcher;
import com.example.StarbucksModel.PaymentsCommand;

@Repository
public interface PaymentsCommandRepository extends JpaRepository<PaymentsCommand, Long> {
	
}
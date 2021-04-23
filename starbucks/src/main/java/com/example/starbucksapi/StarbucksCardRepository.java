package com.example.starbucksapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.ExampleMatcher;

interface StarbucksCardRepository extends JpaRepository<StarbucksCard, Long>{

	StarbucksCard findByCardNumber(String cardNumber);

	StarbucksCard deleteByCardNumber(String cardNumber);
}
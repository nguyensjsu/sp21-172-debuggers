package com.example.StarbucksRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.ExampleMatcher;
import com.example.StarbucksModel.StarbucksCard;
import org.springframework.stereotype.Repository;

@Repository
public interface StarbucksCardRepository extends JpaRepository<StarbucksCard, Long>{

	StarbucksCard findByCardNumber(String cardNumber);

	StarbucksCard deleteByCardNumber(String cardNumber);

	List<StarbucksCard> findByActivated(boolean activated);
}
package com.example.starbucksapi;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
class StarbucksCardController {
	private final StarbucksCardRepository repository;

	StarbucksCardController(StarbucksCardRepository repository){
		this.repository = repository;
	}

	@PostMapping("/cards")
	StarbucksCard newCard(){
		StarbucksCard newcard = new StarbucksCard();
		Random random = new Random();
		int num = random.nextInt(900000000)+100000000;
		int code = random.nextInt(900)+100;

		newcard.setCardNumber(String.valueOf(num));
		newcard.setCardCode(String.valueOf(code));
		newcard.setBalance(20.00);
		newcard.setActivated(false);
		newcard.setStatus("New Card");
		return repository.save(newcard);
	}

	@GetMapping("/cards")
	List<StarbucksCard> all(){
		return repository.findAll();
	}

	@DeleteMapping("/cards")
	String deleteAll(){
		repository.deleteAllInBatch();
		return "all card is deleted";
	}

	@DeleteMapping("/card/{num}")
	String deleteCard(@PathVariable("num") String num){
		StarbucksCard card = repository.findByCardNumber(num);
		if(card.isActivated()){
			repository.delete(card);
			return num + " is deleted";
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not exist");
		}
	}

	@GetMapping("/card/{num}")
	StarbucksCard getOne(@PathVariable("num") String num, HttpServletResponse response){
		StarbucksCard card = repository.findByCardNumber(num);
		if(card == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card not found");
		return card;
	}

	@GetMapping("/card/setActivated/{num}/{code}")
	StarbucksCard activate(@PathVariable("num") String num, @PathVariable("code") String code, HttpServletResponse response){
		StarbucksCard card = repository.findByCardNumber(num);
		if(card == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card not found");
		if(card.getCardCode().equals(code)){
			card.setActivated(true);
			repository.save(card);
		}
		else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card not valid");
		}
		return card;
	}
}


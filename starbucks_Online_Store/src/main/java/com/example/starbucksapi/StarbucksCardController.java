package com.example.starbucksapi;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import com.example.StarbucksModel.StarbucksCard;
import com.example.StarbucksRepository.StarbucksCardRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StarbucksCardController {
	private final StarbucksCardRepository repository;

	StarbucksCardController(StarbucksCardRepository repository){
		this.repository = repository;
	}

	@PostMapping("/newcard")
	public String newCard(){
		StarbucksCard newcard = new StarbucksCard();
		Random random = new Random();
		int num = random.nextInt(900000000)+100000000;
		int code = random.nextInt(900)+100;

		newcard.setCardNumber(String.valueOf(num));
		newcard.setCardCode(String.valueOf(code));
		newcard.setBalance(20.00);
		newcard.setActivated(false);
		newcard.setStatus("New Card");
		repository.save(newcard);
		System.out.println(newcard);
		return "CreateCard";
	}

	@GetMapping("/")
	public String findActiveCard(Model model){
		model.addAttribute("cardList", repository.findByActivated(true));
		return "CardPage";
	}


	@GetMapping("/card/{num}")
	public String deleteCard(@PathVariable("num") String num, Model model){
		StarbucksCard card = repository.findByCardNumber(num);
		repository.delete(card);
		model.addAttribute("cardList", repository.findByActivated(true));
		model.addAttribute("message", " Card is deleted");
		return "CardPage";
	}

	@GetMapping("/balance/{num}")
	public String getBalance(@PathVariable("num") String num, Model model){
		StarbucksCard card = repository.findByCardNumber(num);
		String cardnum = card.getCardNumber();
		String balance = "$" + String.valueOf(card.getBalance());
		model.addAttribute("cardList", repository.findByActivated(true));
		model.addAttribute("balance", balance);
		model.addAttribute("cardNumber", cardnum);
		System.out.println(balance);
		return "CardPage";

	}

	@PostMapping("/card/setActivated/{num}/{code}")
	public String activate(@PathVariable("num") String num, @PathVariable("code") String code, Model model, HttpServletResponse response){
		StarbucksCard card = repository.findByCardNumber(num);
		if(card == null){
			System.out.println("Card not found");
			model.addAttribute("message", "Card not found");
			return "ActiveCardPage";
		}
		if(card.getCardCode().equals(code)){
			card.setActivated(true);
			repository.save(card);
			System.out.println("Card active success");
			model.addAttribute("message", "Card active success");
			return "ActiveCardPage";
		}
		else{
			System.out.println("Error. Card not valid");
			model.addAttribute("message", "Error. Card not valid");
			return "ActiveCardPage";
		}
	}

	@GetMapping("/card/{num}/{money}")
	public String addMoney(@PathVariable("num") String num, @PathVariable("money") String money, Model model){
		StarbucksCard card = repository.findByCardNumber(num);
		double m = card.getBalance();
		m+=Double.parseDouble(money);
		card.setBalance(m);
		repository.save(card);
		System.out.println(m);
		model.addAttribute("cardList", repository.findByActivated(true));
		return "CardPage";
	}
}


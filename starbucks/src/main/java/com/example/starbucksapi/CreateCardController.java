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
public class CreateCardController {
	private final StarbucksCardRepository repository;

	CreateCardController(StarbucksCardRepository repository){
		this.repository = repository;
	}

	@PostMapping("/newcard")
	public String newCard(Model model){
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
		model.addAttribute("tableView", repository.findAll());
		return "BackOffice";
	}

	@GetMapping("/cards")
	public String all(Model model){
		model.addAttribute("tableView", repository.findAll());
		return "BackOffice";
	}

	@PostMapping("/cards")
	public String edite(Model model, HttpServletRequest request){
		Double webBalance;
		if(request.getParameter("id")==""){
			model.addAttribute("massage", "Please enter ID before submit");
			model.addAttribute("tableView", repository.findAll());
			return "BackOffice";
		}
		else{
			long webId = Long.parseLong(request.getParameter("id"));
			StarbucksCard editeCard = repository.findById(webId);
			if(editeCard!=null){
				if(request.getParameter("balance")!="")
					webBalance = Double.parseDouble(request.getParameter("balance"));
				else
					webBalance = editeCard.getBalance();

				boolean webActivated;
				if(request.getParameter("activated")!="")
					webActivated = Boolean.parseBoolean(request.getParameter("activated"));
				else
					webActivated = editeCard.getActivated();

				String webStatus = request.getParameter("status");
				editeCard.setBalance(webBalance);
				editeCard.setActivated(webActivated);
				if(webStatus!="")
					editeCard.setStatus(webStatus);
				repository.save(editeCard);
				model.addAttribute("massage", "Change Success");
				model.addAttribute("tableView", repository.findAll());
				return "BackOffice";
			}
			else{
				System.out.println("card not exist");
				model.addAttribute("massage", "id is not exist");
				model.addAttribute("tableView", repository.findAll());
				return "BackOffice";
			}
		}
	}

}
package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("showWelcome")
	public String showWelcomePage(Model model) {
		List<String> cities = new ArrayList<String>();
		cities.add("Pune"); cities.add("Mumbai"); cities.add("Delhi"); cities.add("Kolkatta");
		model.addAttribute("cityList", cities);
		model.addAttribute("firstName", "Tom");
		
		String countries[] = {"India", "USA", "France"};
		model.addAttribute("countries", countries);
		return "welcome"; //it will render welcome.html
	}
}

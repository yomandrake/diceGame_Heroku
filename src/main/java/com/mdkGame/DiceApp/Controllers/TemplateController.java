package com.mdkGame.DiceApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

	@GetMapping("/canvas")
	public String canvas(@RequestParam(name="name", required=false, defaultValue="from Canvas World") String name, Model model) {
		model.addAttribute("name", name);
		return "canvas";
	}
	
	@GetMapping("/boardgame")
	public String boardgame(@RequestParam(name="name", required=false, defaultValue="to the board Game!") String name, Model model) {
		model.addAttribute("name", name);
		return "boardgame";
	}
	
}
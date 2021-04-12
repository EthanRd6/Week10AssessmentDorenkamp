package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Fighter;
import dmacc.repository.FighterRepository;

/**
 * @author Ethan Dorenkamp - edorenkamp CIS175 - Spring 2021 Apr 2, 2021
 */
@Controller
public class WebController {
	
	@Autowired
	FighterRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllFighters(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewFighter(model);
		}

		model.addAttribute("fighters", repo.findAll());
		return "results";
	}

	@GetMapping("/inputFighter")
	public String addNewFighter(Model model) {
		Fighter f = new Fighter();
		model.addAttribute("newFighter", f);
		return "input";
	}

	@PostMapping("/inputFighter")
	public String addNewFighter(@ModelAttribute Fighter f, Model model) {
		repo.save(f);
		return viewAllFighters(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateFighter(@PathVariable("id") long id, Model model) {
		Fighter f = repo.findById(id).orElse(null);
		model.addAttribute("editFighter", f);
		return "edit";
	}

	@PostMapping("/update/{id}")
	public String reviseFighter(Fighter f, Model model) {
		repo.save(f);
		return viewAllFighters(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Fighter f = repo.findById(id).orElse(null);
		repo.delete(f);
		return viewAllFighters(model);
	}
}

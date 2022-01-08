package ari.project.ARI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.project.ARI.models.Library;
import ari.project.ARI.repositories.LibraryRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LibraryController {
	@Autowired
	private LibraryRepository lr;
	
	@ModelAttribute("lib")
	public Library lib() {
	    return new Library();
	}
	
	@CrossOrigin
	@PostMapping("/createLibrary")
	public String createLibrary(@RequestParam String name) {
		Library library = new Library(name);
		this.lr.save(library);
		return "redirect:/";
	}
	
	@CrossOrigin
	@GetMapping("/")	
    public String getLibrary(Model m) {
        m.addAttribute("librarys", this.lr.findAll());
        return "home";
    }	
	
	//Marche pas
	@CrossOrigin
	@PostMapping("/selectLibrary")
	public String selectLibrary(@ModelAttribute("lib") @Validated @RequestBody
			Library lib, Model model) {
		model.addAttribute("libID", lib.getId());
		System.out.println(lib.getName());
		return "redirect:/";
	}
}

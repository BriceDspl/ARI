package ari.project.ARI.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.project.ARI.models.Author;
import ari.project.ARI.models.Book;
import ari.project.ARI.repositories.AuthorRepository;
import ari.project.ARI.repositories.LibraryRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AuthorController {
	@Autowired
	private AuthorRepository ar;
	
	@Autowired
	private LibraryRepository lr;
	
	@CrossOrigin
	@PostMapping("/createAuthor")
	public String createAuthor(@RequestParam String firstName, @RequestParam String lastName) {
		Author author = new Author(firstName,lastName, lr.findById(1), new ArrayList<Book>());
		this.ar.save(author);
		return "redirect:/getAuthors";
	}
	
	@CrossOrigin
	@GetMapping("/getAuthors")	
    public String getAuthors(Model m) {
        m.addAttribute("authors", this.ar.findAll());
        return "author";
    }
    
    @PostMapping("/updateAuthor/{id}")
    public String updateAuthor(@PathVariable("id") String id, @RequestParam String firstName,@RequestParam String lastName) {
        Author author = this.ar.findById(Integer.parseInt(id));
        author.setFirstName(firstName);
        author.setLastName(lastName);
        this.ar.save(author);
    	return "redirect:/getAuthors";
    }
    
    @PostMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable("id") String id){
        this.ar.deleteById(Integer.parseInt(id));
        return "redirect:/getAuthors";
    }
	
	
}

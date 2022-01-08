package ari.project.ARI.controllers;

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
import ari.project.ARI.repositories.BookRepository;
import ari.project.ARI.repositories.LibraryRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookController {
	@Autowired
	private BookRepository br;
	
	@Autowired
	private AuthorRepository ar;
	
	@Autowired
	private LibraryRepository lr;
	@CrossOrigin
	@PostMapping("/createBook")
	public String createBook(@RequestParam String title, @RequestParam String authorName) {
		List<Author> author = this.ar.findByLastName(authorName);
		Book book = new Book(title, lr.findById(1), author);
		this.br.save(book);
		return "redirect:/getBooks";
	}
	
	@CrossOrigin
	@GetMapping("/getBooks")	
    public String getBooks(Model m) {
        m.addAttribute("books", this.br.findAll());
        return "book";
    }
    
    @PostMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") String id, @RequestParam String title) {
        Book book = this.br.findById(Integer.parseInt(id));
        book.setTitle(title);
        this.br.save(book);
    	return "redirect:/getBooks";
    }
    
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") String id){
        this.br.deleteById(Integer.parseInt(id));
        return "redirect:/getBooks";
    }
	
	
}

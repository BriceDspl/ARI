package ari.project.ARI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.project.ARI.models.Reader;
import ari.project.ARI.repositories.LibraryRepository;
import ari.project.ARI.repositories.ReaderRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReaderController {
	@Autowired
	private ReaderRepository rp;
	
	@Autowired
	private LibraryRepository lr;
	
	@CrossOrigin
	@PostMapping("/createReader")
	public String createReader(@RequestParam String firstName, @RequestParam String lastName) {
		Reader reader = new Reader(firstName,lastName, lr.findById(1));
		this.rp.save(reader);
		return "redirect:/getReaders";
	}
	
	@CrossOrigin
	@GetMapping("/getReaders")	
    public String getReaders(Model m) {
        m.addAttribute("readers", this.rp.findAll());
        return "reader";
    }
    
    @PostMapping("/updateReader/{id}")
    public String updateReader(@PathVariable("id") String id, @RequestParam String firstName,@RequestParam String lastName) {
        Reader reader = this.rp.findById(Integer.parseInt(id));
        reader.setFirstName(firstName);
        reader.setLastName(lastName);
        this.rp.save(reader);
    	return "redirect:/getReaders";
    }
    
    @PostMapping("/deleteReader/{id}")
    public String deleteReader(@PathVariable("id") String id){
        this.rp.deleteById(Integer.parseInt(id));
        return "redirect:/getReaders";
    }
	
	
}

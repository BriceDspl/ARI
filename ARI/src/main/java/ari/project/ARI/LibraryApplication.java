package ari.project.ARI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ari.project.ARI.models.Author;
import ari.project.ARI.models.Library;
import ari.project.ARI.models.Reader;
import ari.project.ARI.repositories.AuthorRepository;
import ari.project.ARI.repositories.BookRepository;
import ari.project.ARI.repositories.LibraryRepository;
import ari.project.ARI.repositories.ReaderRepository;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner init(AuthorRepository authorRepository, BookRepository bookRepository, LibraryRepository libraryRepository, ReaderRepository readerRepository) {
        return args -> {
            Library library = new Library("Library");
            library = libraryRepository.save(library);
            Library ebrary = new Library("Ebrary");
            ebrary = libraryRepository.save(ebrary);

            Author author = new Author("Georges", "Martin");
            author = authorRepository.save(author);
            
            Reader reader = new Reader("Alan", "Walker");
            reader = readerRepository.save(reader);
            
        };
    }

}
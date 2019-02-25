package com.peka.bookstore.book;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.peka.bookstore.exception.BookNotFoundExceptions;

@RestController
public class BookJpaResource {

	
	@Autowired
	private BookRepository jpaRepository;
	
	@Autowired
	private AuthorRepository authorJpaRepository; 
	
	@GetMapping(path="/jpa/books")
	public List<Book> retriveindAllBooks(){
		return jpaRepository.findAll();
	}
	
	@GetMapping(path="/jpa/books/{id}")
	public Optional<Book> RetriveOneBook(@PathVariable int id){
		Optional<Book> book = jpaRepository.findById(id);
		if(!book.isPresent())
			throw new BookNotFoundExceptions("id - "+ id);
		return book;
	}

	
	@DeleteMapping(path="/jpa/books/{id}")
	public void DeleteBookById(@PathVariable int id) {
		jpaRepository.deleteById(id);
	}
	
	
	@PostMapping("/jpa/author/{author_id}/books")
	public ResponseEntity<Object> createBook(@PathVariable int author_id, @RequestBody Book book) {
			Optional<Author> authorOptional = authorJpaRepository.findById(author_id);
			if(!authorOptional.isPresent())
				throw new BookNotFoundExceptions("id - "+ author_id);
		
		Author author2 = authorOptional.get();
		
		book.setAuthor(author2);
		jpaRepository.save(book);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
}

package com.peka.bookstore.book;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.peka.bookstore.exception.BookNotFoundExceptions;

@RestController
public class AuthorJpaResource {

	@Autowired
	private AuthorRepository authorJpaRepository;
	
	@GetMapping(path="/jpa/author")
	public List<Author> retriveindAllAuthors(){
		return authorJpaRepository.findAll();
	}
	
	@GetMapping(path="/jpa/author/{author_id}/books")
	public List<Book> RetriveOneAuthor(@PathVariable int author_id){
		Optional<Author> author = authorJpaRepository.findById(author_id);
		if(!author.isPresent())
			throw new BookNotFoundExceptions("id - "+ author_id);
		return author.get().getBooks();
	}
	
//	@PostMapping("/jpa/author/{author_id}/books")
//	public ResponseEntity<Object> createBook(@PathVariable int author_id, @RequestBody Book books) {
//		
//		Optional<Author> authorOptional = authorJpaRepository.findById(author_id);
//		if(!authorOptional.isPresent())
//			throw new BookNotFoundExceptions("id - "+ author_id);
//		
//		Author author = authorOptional.get();
//		
//		books.setAuthor(author);
//		authorJpaRepository.save(author);
//		
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(books.getId()).toUri();
//		return ResponseEntity.created(location).build(); //dokończyć  step 35
//	}
	
	@PostMapping("/jpa/author")
	public ResponseEntity<Object> createAuthor(@RequestBody Author author) {
		Author savedAuthor = authorJpaRepository.save(author);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAuthor.getAuthorId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
}

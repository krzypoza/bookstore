package com.peka.bookstore.book;

import java.net.URI;
import java.util.List;

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
public class BookResource {

	@Autowired
	private BookDaoService service;
	
	@GetMapping(path="/books")
	public List<Book> retriveindAllBooks(){
		return service.findAll();
	}
	
	@GetMapping(path="/books/{id}")
	public Book RetriveOneBook(@PathVariable int id){
		Book book = service.findOne(id);
		if(book==null)
			throw new BookNotFoundExceptions("id - "+ id);
		return book;
	}

	
	
	@DeleteMapping(path="/books/{id}")
	public void DeleteBookById(@PathVariable int id) {
		Book book = service.DeleteById(id);
		if(book==null)
			throw new BookNotFoundExceptions("id - "+ id);
	}
	
//	@DeleteMapping(path="/books/{title}")
//	public void DeleteBookByTitle(@PathVariable String title) {
//		Book book = service.DeleteByTitle(title);
//		if(book==null)
//			throw new BookNotFoundExceptions("title - "+ title);
//	}
	
	@PostMapping("/books")
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		Book savedBook = service.save(book);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBook.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
}

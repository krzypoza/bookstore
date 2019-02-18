package com.peka.bookstore.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookDaoService {
	private static List<Book> books = new ArrayList<>();
	
	private static int booksCount = 3;
	
	static {
		books.add(new Book(1, "title_1", "Author_1"));
		books.add(new Book(2, "title_2", "Author_2"));
		books.add(new Book(3, "title_3", "Author_3"));
	}

	public List<Book> findAll(){
		return books;
	}
	
	public Book save(Book book) {
		if(book.getId() == null) {
			book.setId(++booksCount);
		}
		books.add(book);
		return book;
	}
	
	public Book findOne(int id) {
		for(Book book:books) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public Book DeleteById(int id) {
		Iterator<Book> iterator = books.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getId() == id) {
				iterator.remove();
				return book;
			}
		}
		return null;
	}
	
//	public Book DeleteByTitle(String title) {
//		Iterator<Book> iterator = books.iterator();
//		while(iterator.hasNext()) {
//			Book book = iterator.next();
//			if(book.getTitle() == title) {
//				iterator.remove();
//				return book;
//			}
//		}
//		return null;
//	}
}

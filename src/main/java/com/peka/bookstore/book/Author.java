package com.peka.bookstore.book;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Integer author_id;
	
	private String name;
	
	private String surname;
	
	@OneToMany(mappedBy="author2")
	private List<Book> books; // adnotacja oneToMany czyli jeden autor może mieć wiele książek mappedBy wskazuje po czym te tabele mają się łączyć (join on) i tworzy kolumnę author2_author_id, id jest polem @id book

	public Author() {
		
	}
	
	public Author(Integer author_id, String name, String surname, List<Book> books) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.surname = surname;
		this.books = books;
	}

	public Integer getAuthorId() {
		return author_id;
	}

	public void setId(Integer author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", name=" + name + ", surname=" + surname + 
				", books=" + books + 
				"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author_id == null) ? 0 : author_id.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (author_id == null) {
			if (other.author_id != null)
				return false;
		} else if (!author_id.equals(other.author_id))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Author [author_id=" + author_id + ", name=" + name + ", surname=" + surname + "]";//nie dodajemy book bo stworzy się pętla 
//	}

	
}

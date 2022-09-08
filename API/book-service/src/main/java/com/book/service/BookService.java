package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.modal.Books;

@Service
public interface BookService {
	
	public List<Books> saveBooks(List<Books> bookDetails) throws Exception;
	public List<Books> getBooks() throws Exception;
	public Books getBookById(Integer bookId) throws Exception;
	public Books editBookDetails(Books book) throws Exception;
	public List<Books> deleteBookDetails(List<Integer> bookIds) throws Exception;

}

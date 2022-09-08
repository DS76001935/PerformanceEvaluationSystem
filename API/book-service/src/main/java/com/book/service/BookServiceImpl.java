package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.modal.Books;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Books> saveBooks(List<Books> bookDetails) throws Exception {

		List<Books> regList = new ArrayList<Books>();

		for (Books element : bookDetails) {
			Books obj = bookRepo.save(element);
			regList.add(obj);
		}

		return regList;
	}

	@Override
	public List<Books> getBooks() throws Exception {

		return bookRepo.findAll();
	}

	@Override
	public Books getBookById(Integer bookId) throws Exception {

		Books book = null;

		if (bookId != null) {
			book = bookRepo.findBooksByBookId(bookId);
		}

		return book;
	}

	@Override
	public Books editBookDetails(Books book) throws Exception {

		Books bookInfo = new Books();

		if (book.getBookId() != null) {
			bookInfo.setBookId(book.getBookId());
			bookInfo.setBookName(book.getBookName());
			bookInfo.setIsbnNo(book.getIsbnNo());
			bookInfo.setPages(book.getPages());
			bookInfo.setAuthorName(book.getAuthorName());
			bookInfo.setPublicationName(book.getPublicationName());

			bookRepo.save(bookInfo);
		}
		return bookInfo;
	}

	@Override
	public List<Books> deleteBookDetails(List<Integer> bookIds) throws Exception {
		Books book = null;
		List<Books> removedEntities = new ArrayList<Books>();
		for (Integer id : bookIds) {
			book = bookRepo.findBooksByBookId(id);
			if (book != null) {
				bookRepo.delete(book);
				removedEntities.add(book);
			}
		}

		return removedEntities;
	}

}

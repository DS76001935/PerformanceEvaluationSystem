package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.modal.Books;
import com.book.modal.ResponseEntity;
import com.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	public ResponseEntity<List<Books>> saveBooks(@RequestBody List<Books> bookDetails) throws Exception {
		ResponseEntity<List<Books>> res = new ResponseEntity<List<Books>>();

		List<Books> list = bookService.saveBooks(bookDetails);

		if (list.size() > 0) {
			res.setData(list);
			res.setMessage("Book(s) saved successfully in the system!");
			res.setStatus(200);
		} else {
			res.setData(null);
			res.setMessage("!! Somthing went wrong in the registration of book(s) fron the system !!");
			res.setStatus(-1);
		}

		return res;
	}

	@GetMapping("/getBookData")
	public ResponseEntity<List<Books>> saveBooks() throws Exception {
		ResponseEntity<List<Books>> res = new ResponseEntity<List<Books>>();

		List<Books> list = bookService.getBooks();

		if (list.size() > 0) {
			res.setData(list);
			res.setMessage("Data has been retrieved successfully!");
			res.setStatus(200);
		} else {
			res.setData(null);
			res.setMessage("!! Somthing went wrong in the retrival of all books fron the system !!");
			res.setStatus(-1);
		}

		return res;
	}

	@GetMapping("/getById")
	public ResponseEntity<Books> getBookById(@RequestParam("bookId") Integer bookId) throws Exception {
		ResponseEntity<Books> res = new ResponseEntity<Books>();

		Books book = bookService.getBookById(bookId);

		if (book != null) {
			res.setData(book);
			res.setMessage("Book has been retrieved successfully By Its Id!");
			res.setStatus(200);

		} else {
			res.setData(null);
			res.setMessage("!! Somthing went wrong in the retrival of the book from system !!");
			res.setStatus(-1);
		}

		return res;
	}

	@PutMapping("/edit")
	public ResponseEntity<Books> editBookDetails(@RequestBody Books book) throws Exception {
		ResponseEntity<Books> res = new ResponseEntity<Books>();

		Books bookObj = bookService.editBookDetails(book);

		if (bookObj != null) {
			res.setData(bookObj);
			res.setMessage("Book has been Updated successfully By Its Id!");
			res.setStatus(200);

		} else {
			res.setData(null);
			res.setMessage("!! Somthing went wrong in the updation of the book from system !!");
			res.setStatus(-1);
		}

		return res;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<List<Books>> deleteBookDetails(@RequestBody List<Integer> bookIds) throws Exception{
		
		ResponseEntity<List<Books>> res = new ResponseEntity<List<Books>>();
		List<Books> removedBookList = bookService.deleteBookDetails(bookIds);

		if (removedBookList.size() > 0) {
			res.setData(removedBookList);
			res.setMessage("Book(s) has been deleted successfully By Id(s)!");
			res.setStatus(200);

		} else {
			res.setData(null);
			res.setMessage("!! Somthing went wrong in the deletion of the book(s) from system !!");
			res.setStatus(-1);
		}

		return res;
		
	}

}

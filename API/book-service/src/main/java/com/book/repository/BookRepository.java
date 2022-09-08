package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.modal.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
	
	public Books findBooksByBookId(Integer bookId);

}

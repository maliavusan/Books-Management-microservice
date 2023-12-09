package com.management.books.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.management.books.model.Book;
import com.management.books.repository.BookRepository;
import com.management.books.util.HelperUtil;

@RestController
@RequestMapping("/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepository;

	@GetMapping(value="/getbooks", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAllBooks(){

		return ResponseEntity.ok(bookRepository.findAll());
	}

	@GetMapping(value = "/getbook/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getBook(@PathVariable(value = "id") Long bookId){
		try {
				Book book = bookRepository.findById(bookId).get();

			return ResponseEntity.ok(book);
		} catch (Exception e) {
			logger.error("Error when getting book with id " + bookId, e);

			return HelperUtil.returnServerErrorMessage("Error when getting book " ,e.getMessage());
		}
	}
	
	@PostMapping(value = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE,
					 produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createBook( @RequestBody Book book) {
		try {
			 	bookRepository.save(book);
				logger.info("Book created successfully");

			 return ResponseEntity.ok(book);
		} catch (Exception e) {
					logger.error("Error when creating book " , e);

			return HelperUtil.returnServerErrorMessage("Error when creating book " ,e.getMessage());
		}
		
	}

	@PutMapping(value = "/updateBook/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateBook(@PathVariable(value = "id") Long bookId,
	@RequestBody Book bookDetails){
		
		try {
				Book book = bookRepository.findById(bookId).get();

				book.setName(bookDetails.getName());
				book.setIsbnNumber(bookDetails.getIsbnNumber());
				book.setPublishDate(bookDetails.getPublishDate());
				book.setPrice(bookDetails.getPrice());
				book.setBookType(bookDetails.getBookType());

				final Book updatedBook = bookRepository.save(book);

				logger.info("Book updated successfully");
			return ResponseEntity.ok(updatedBook);
			
		} catch (Exception e) {
		
			logger.error("Error when updating book with id " + bookId, e);

			return HelperUtil.returnServerErrorMessage("Error when updating book " ,e.getMessage());
		}
			
		
	}
	
	@DeleteMapping(value = "/removeBook/{id}" ,
					 produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteBook(@PathVariable(value = "id") Long bookId)
	 {
		try {
				Book book = bookRepository.findById(bookId).get();
				
				bookRepository.delete(book);
				
				logger.info("Book deleted successfully");
			return ResponseEntity.ok(book);
		}catch(Exception e) {
			logger.error("Error when deleting book with id: "+ bookId, e);

			return HelperUtil.returnServerErrorMessage("Error when deleting book " ,e.getMessage());
		}
		
	}
}

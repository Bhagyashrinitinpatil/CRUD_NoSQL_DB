package com.batch91.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch91.model.Book;
import com.batch91.repository.BookRepository;

@RestController
public class BookController {
	
	private BookRepository bookRepository;
	
	
	/**
	 * @param bookRepository
	 */
	@Autowired
	public BookController(BookRepository bookRepository)
	{
		super();
		this.bookRepository = bookRepository;
	}

    //Simple Get and Post method implementation
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
		
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks() 
	{
		return bookRepository.findAll();
	}
	
	//Get and Put and Delete method implementation based on Parameter (book id)

	
	@GetMapping("book/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable int bookId)
	{	
		try 
		{
			Book book = bookRepository.findById(bookId).get();
			return new ResponseEntity<>(book,HttpStatus.OK);	
		}
		catch(NoSuchElementException e) 
		{
			return new ResponseEntity<>("Book not available",HttpStatus.NOT_FOUND);			
		}		
	}
	

	@PutMapping("/book/{bookId}")
	public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable int bookId){
		try {
			if(bookRepository.findById(bookId).get().getBookId() == bookId) {
				Book book1 = bookRepository.save(book);
				return new ResponseEntity<>(book1,HttpStatus.OK);
			}
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>("Book record not updated",HttpStatus.NOT_FOUND);
		}
		
		return null;
		
	}
	
	
	/*@PutMapping("/book/{bookId}")
	public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable int bookId) {
		
		Optional<Book> bookData = bookRepository.findById(bookId);
		
		try
		 { 
		 if(bookData.isPresent()) {
			 Book book1 = bookData.get();
				book1.setBookId(book.getBookId());
				book1.setBookName(book.getBookName());
				book1.setAuthorName(book.getAuthorName());
				book1.setBookPrice(book.getBookPrice());
			return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
			 
		 }
		 }
		 catch(NoSuchElementException e){
			 return new ResponseEntity<>("Not book record updated",HttpStatus.NOT_FOUND);
		 }
		 	
		return null;
	}*/

	
	 
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId)
	{
		 try 
		 {
			 if(bookRepository.findById(bookId).get().getBookId() == bookId)
			 {
				bookRepository.deleteById(bookId);				 
				 return new ResponseEntity<>("Book record deleted successfully",HttpStatus.OK);
			 }
		 }
		 catch(NoSuchElementException e) 
		 {
			 return new ResponseEntity<>("Book record not exist",HttpStatus.NOT_FOUND);
		 }
		return null;	 
	 }
	
	
}


	
	
	
	
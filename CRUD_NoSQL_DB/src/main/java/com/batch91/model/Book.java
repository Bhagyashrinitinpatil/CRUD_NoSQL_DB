/**
 * 
 */
package com.batch91.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * @author BHAGYASHRI
 *
 */

//We adding Document annotation while dealing with NoSQL databases

@Document
public class Book {
	
	//Here we refer bookId as primary key
	@Id
	private int bookId;
	private String bookName;
	private String authorName;
	private double bookPrice;
	
	/**
	 * 
	 */
	public Book() {
		super();
	}
	
	/**
	 * @param bookId
	 * @param bookName
	 * @param authorName
	 * @param bookPrice
	 */
	public Book(int bookId, String bookName, String authorName, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
	}
	
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}
	
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	/**
	 * @return the bookPrice
	 */
	public double getBookPrice() {
		return bookPrice;
	}
	
	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	

}

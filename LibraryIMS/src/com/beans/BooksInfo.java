package com.beans;

public class BooksInfo {
	private int BookId;
	private String bookName;
	private String author;
	private String publication;
	private String Subject;
	private int noOfCopies;
	
	
	
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int BookId) {
		this.BookId = BookId;
	}
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
}

package com.beans;

public class StudentReport {

	public int getLibraryid() {
		return libraryid;
	}
	public void setLibraryid(int libraryid) {
		this.libraryid = libraryid;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getNum_of_copies() {
		return Num_of_copies;
	}
	public void setNum_of_copies(int num_of_copies) {
		Num_of_copies = num_of_copies;
	}
	private static int libraryid;
	private String branch;
	private String semester;
	private int BookId;
	private String BookName;
	private String Author;
	private String publication;
	private int Num_of_copies;
}

package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.StudentReport;



public class StudentReportDAO {

public static Connection getConnection() {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/db_lib","root", "AKHILKATTI01");
			System.out.println("Connected");
			return con;
		
		
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
			
  }

public static ArrayList<StudentReport> displayData(StudentReport studentreport, Connection con) {
	
	try {
		
	String sq="select BookId, BookName, Author, Publication,Num_of_copies,Libraryid,Branch,Semester from BooksInfo,student";

	PreparedStatement p;
	p = con.prepareStatement(sq);
	ResultSet rs=p.executeQuery();
	
	ArrayList<StudentReport> al = new ArrayList<StudentReport>();
	if(al!=null) {
	while(rs.next()) {
	
		StudentReport studentreport1 = new StudentReport();
		p = con.prepareStatement(sq);
		studentreport1.setLibraryid(rs.getInt(1));
		studentreport1.setBranch(rs.getString(2));
		studentreport1.setSemester(rs.getString(3));
		studentreport1.setBookId(rs.getInt(4));
		studentreport1.setAuthor(rs.getString(5));
		studentreport1.setPublication(rs.getString(6));
		studentreport1.setNum_of_copies(rs.getInt(7));
		
		al.add(studentreport1);
		
		}
	}
	return al;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
}



}

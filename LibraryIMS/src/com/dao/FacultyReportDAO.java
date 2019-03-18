package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.FacultyReport;


public class FacultyReportDAO {

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



public static ArrayList<FacultyReport> displayData(FacultyReport facultyreport, Connection con) {
	try {
		
		String sq="select BookId, BookName, Author, Publication,Num_of_copies,student,TeacherId,Branch from BooksInfo, Teachers ";
		PreparedStatement p;
		p = con.prepareStatement(sq);
		ResultSet rs=p.executeQuery();
		
		ArrayList<FacultyReport> a1 = new ArrayList<FacultyReport>();
		
		if(a1!=null) {
		while(rs.next()) {
			
			FacultyReport facultyreport1 = new FacultyReport();
			p = con.prepareStatement(sq);
			facultyreport1 .setTeacherId(rs.getInt(1));
			facultyreport1 .setBookId(rs.getInt(2));
			facultyreport1 .setBranch(rs.getString(3));
			facultyreport1 .setBookName(rs.getString(4));
			facultyreport1 .setAuthor(rs.getString(5));
			facultyreport1 .setPublication(rs.getString(6));
			facultyreport1 .setNum_of_copies(rs.getInt(7));
			
			a1.add(facultyreport1);
			
		}
		
		}

		return a1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	
	
	}
}
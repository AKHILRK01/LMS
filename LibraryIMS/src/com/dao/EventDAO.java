package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.beans.EventsInfo;

public class EventDAO {

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

		public static void insertData(EventsInfo events,Connection con) {
			
			String sq="insert into detail values(?,?,?,?,?,?)";
			PreparedStatement p;
			
			try {
				p = con.prepareStatement(sq);
				p.setString(1,events.getE_Name());
				p.setString(2,events.getE_date());
				p.setString(3,events.getE_MName());
				p.setLong(4,events.getE_ContactNo());
				p.setString(5,events.getE_Email());
				p.setString(6,events.getVenue());
				
				
				p.executeUpdate();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}

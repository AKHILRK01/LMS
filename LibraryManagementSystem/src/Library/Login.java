package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login {

	public static Connection getConnection() {
		try
		{
		
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		//CREATE THE CONNECTION
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_lib", "root", "AKHILKATTI01");
		System.out.println("Connected Successfully");
		
		return con;
	}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<User> displayData(Connection con) {
		String sqlExecute = " select * from db_lib.login where username=? and passw=?";
		PreparedStatement pstmt;
		try
		{
			pstmt = con.prepareStatement(sqlExecute);
			ArrayList<User> a1 = new ArrayList<User>();
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setName(((ResultSet) rs).getString(1));
				user.setPassword(rs.getString(2));
			a1.add(user);
			}
			
			pstmt.close();
			rs.close();
			con.close();
			return a1;
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
	}

	public static boolean validate(String username, String newpassword, String confirmpassword, Connection con) {
		boolean flag =false;
		try {

		            String sql = "select * from db_lib.login where username=? and passw=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, newpassword);
					pstmt.setString(2, confirmpassword);
					ResultSet rs = pstmt.executeQuery();
					
		            while (rs.next()) 
		            {
		    			flag=true;
		    			break;
		    		}
		    	
		    		return flag;
		}
		
	
					catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	
		return flag;
	}

	public static void insertData(User user, Connection con) {
		String sql = "Insert into db_lib.login where username=? and passw=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getName());
		pstmt.setString(2,user.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
		
	}

	
	 
			
}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.beans.StudentReport;
import com.dao.StudentReportDAO;

/**
 * Servlet implementation class StudentReportServlet
 */
@WebServlet("/StudentReportServlet")
public class StudentReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("StudentReport Servlet");
		Connection con=StudentReportDAO.getConnection();
				
		int Libraryid=Integer.parseInt(request.getParameter("Libraryid"));
		String branch=request.getParameter("branch");
		String semester=request.getParameter("semester");
		int BookId=Integer.parseInt(request.getParameter("BookId"));
		String BookName=request.getParameter("bookName");
		String Author=request.getParameter("author");
		int num_of_copies=Integer.parseInt(request.getParameter("num_of_copies"));
		
		StudentReport studentreport = new StudentReport();
		studentreport.setLibraryid(Libraryid);
		studentreport.setBranch(branch);
		studentreport.setSemester(semester);
		studentreport.setBookId(BookId);
		studentreport.setBookName(BookName);
		studentreport.setAuthor(Author);
		studentreport.setNum_of_copies(num_of_copies);
		
		PrintWriter pw= response.getWriter();
		ArrayList<StudentReport> al= StudentReportDAO.displayData(studentreport,con);
		RequestDispatcher rd = request.getRequestDispatcher("GenerateReport.jsp");
		request.setAttribute("studentreport", al);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

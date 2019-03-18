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

import com.beans.FacultyReport;
import com.beans.StudentReport;
import com.dao.FacultyReportDAO;
import com.dao.StudentReportDAO;

/**
 * Servlet implementation class FacultyReport
 */
@WebServlet("/FacultyReport")
public class facultyreport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public facultyreport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("FacultyReport Servlet");
		Connection con=FacultyReportDAO.getConnection();
				
		int Teacherid=Integer.parseInt(request.getParameter("teacherId"));
		String branch=request.getParameter("branch");
		int BookId=Integer.parseInt(request.getParameter("bookId"));
		String BookName=request.getParameter("bookName");
		String Author=request.getParameter("author");
		String Publication=request.getParameter("publication");
		int Num_of_copies=Integer.parseInt(request.getParameter("num_of_copies"));
		
		FacultyReport facultyreport = new FacultyReport();
		facultyreport.setTeacherId(Teacherid);
		facultyreport.setBookId(BookId);
		facultyreport.setBranch(branch);
		facultyreport.setBookName(BookName);
		facultyreport.setAuthor(Author);
		facultyreport.setPublication(Publication);
		facultyreport.setNum_of_copies(Num_of_copies);
		
		PrintWriter pw= response.getWriter();
		ArrayList<FacultyReport> al= FacultyReportDAO.displayData(facultyreport,con);
		RequestDispatcher rd = request.getRequestDispatcher("GenerateReport.jsp");
		request.setAttribute("facultyreport", al);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

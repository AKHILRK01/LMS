<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="java.util.*,com.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentReportServlet">
<table border=2 cellspacing=2 cellpadding=2>
<tr>
<th>libraryid</th><th>Branch</th><th>semester</th><th>BookId</th><th>BookName</th><th>Author</th><th>Publication</th><th>No. of Copies</th><th>
<input type = "submit" value ="StudentReport"/></th>
</tr>

<tr>
<td><%= request.getParameter("libraryid")%></td>
<td><%= request.getParameter("branch")%></td>
<td><%= request.getParameter("semester")%></td>
<td><%= request.getParameter("bookId")%></td>
<td><%= request.getParameter("bookName")%></td>
<td><%= request.getParameter("author")%></td>
<td><%= request.getParameter("num_of_copies")%></td>

</tr>

<%
	ArrayList<StudentReport> al=(ArrayList)request.getAttribute("studentreport");

	Iterator<StudentReport> it=al.iterator();

	while(it.hasNext()){
	StudentReport d= it.next();
%>


		
		<tr>
		<td><%=d.getLibraryid() %></td>
		<td><%=d.getBranch() %></td>
		<td><%=d.getSemester() %></td>
		<td><%=d.getBookId() %></td>
		<td><%=d.getBookName() %></td>
		<td><%=d.getAuthor() %></td>
		<td><%=d.getNum_of_copies() %></td>
		
		</tr>
		
<% 	}	%>
</table>
</form>

<form>

<table border=2 cellspacing=2 cellpadding=2>
<tr>
<th>TeacherId</th><th>Branch</th><th>BookId</th><th>BookName</th><th>Author</th><th>Publication</th><th>No. of Copies</th><th>
<input type = "submit" form action = "facultyreport.java" value ="FacultyReport"/></th>
</tr>

<tr>
<td><%= request.getParameter("teacherId")%></td>
<td><%= request.getParameter("branch")%></td>
<td><%= request.getParameter("bookId")%></td>
<td><%= request.getParameter("bookName")%></td>
<td><%= request.getParameter("author")%></td>
<td><%= request.getParameter("publication")%></td>
<td><%= request.getParameter("num_of_copies")%></td>

</tr>

<%
	ArrayList<FacultyReport> a1=(ArrayList)request.getAttribute("facultyreport");

	Iterator<FacultyReport> itr=a1.iterator();
	while(it.hasNext()){		
		FacultyReport d= (FacultyReport)itr.next();
%>


		
		<tr>
		<td><%=d.getTeacherId() %></td>
		<td><%=d.getBranch() %></td>
		<td><%=d.getBookId() %></td>
		<td><%=d.getBookName() %></td>
		<td><%=d.getAuthor() %></td>
		<td><%=d.getPublication() %></td>
		<td><%=d.getNum_of_copies() %></td>
		
		</tr>
			
<% 	}	%>

</tr>
</table>
</form>

</body>
</html>
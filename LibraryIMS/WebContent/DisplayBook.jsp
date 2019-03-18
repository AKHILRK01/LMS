<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	
	<table cellspacing="2" border="1">
<tr>
<th>BookId</th><th>BookName</th><th>Author</th><th>Publication</th><th>Branch</th><th>No. of Copies</th><th>
</tr>

<%
	ArrayList<BooksInfo> al=(ArrayList)request.getAttribute("books");

	Iterator<BooksInfo> it=al.iterator();
	while(it.hasNext()){		
		BooksInfo d= (BooksInfo)it.next();%>
		
		<tr>
		<td><%=d.getBookId() %></td>
		<td><%=d.getBookName() %></td>
		<td><%=d.getAuthor() %></td>
		<td><%=d.getPublication() %></td>
		<td><%=d.getSubject() %></td>
		<td><%=d.getNoOfCopies() %></td>
		<td><input type="button" value="Reserve"><input type="button" value="Cancel"></td>
		</tr>
			
<% 	}	%>


</table>
</form>
</body>
</html>
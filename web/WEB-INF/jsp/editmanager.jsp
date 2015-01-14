<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Model.Role" %>
<%@ page import="Model.EmployeeEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: akshay.Gupta
  Date: 1/14/2015
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="addManager.html" method="post" >

Username <br>
<input type ="text" name="username"><br>
Manager <br>
<input type ="text" name ="manager"><br>
<br>
<input type="submit" value="add">
</form>
<%
    List l = (List)request.getAttribute("list");
    out.print("<table>");
    out.print("<tr> <td >username </td> <td> Manager </td> </tr>");
    for (Iterator it = l.iterator(); it.hasNext();) {
        EmployeeEntity e = (EmployeeEntity)it.next();
        out.print("<tr>");
        out.print("<td align='center'>"+e.getUsername()+"</td>");
        out.print("<td align='center'>"+e.getManager()+"</td>");
        out.print("<td align='center'><form method='post' action='delManager.html'>");
        out.print("<input type='hidden' value='"+e.getUsername()+"' name='username'>");
        out.print("<input type='hidden' value='"+e.getManager()+"' name='manager'>");
        out.print("<input type='submit' value='DELETE'></form></td>");
        out.print("</tr>");
    }
    out.print("</table>");
%>

</body>
</html>

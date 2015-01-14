<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Model.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: akshay.Gupta
  Date: 1/14/2015
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script language="JavaScript" >
        function fun(){
            var username=document.getElementById("username");
            var role = document.getElementById("role");
            if(username.value == "" || role.value ==""){
                alert("Fields can't be left blank");
                return false;
            }


        }
    </script>
    <title></title>
</head>
<body>


<form action="addRole.html" method="post" onsubmit="return fun()">

    Username <br>
    <input type ="text" name="username"><br>
    Role <br>
    <input type ="text" name ="role"><br>
    <br>
    <input type="submit" value="add">
</form>
<%
    List l = (List)request.getAttribute("list");
    out.print("<table>");
    out.print("<tr> <td >username </td> <td> Role </td> </tr>");
    for (Iterator it = l.iterator(); it.hasNext();) {
        Role user = (Role)it.next();
        out.print("<tr>");
        out.print("<td align='center'>"+user.getUsername()+"</td>");
        out.print("<td align='center'>"+user.getRole()+"</td>");
        out.print("<td align='center'><form method='post' action='delRole.html'>");
        out.print("<input type='hidden' value='"+user.getUsername()+"' name='username'>");
        out.print("<input type='hidden' value='"+user.getRole()+"' name='role'>");
        out.print("<input type='submit' value='DELETE'></form></td>");
        out.print("</tr>");
    }
    out.print("</table>");
%>

</body>
</html>

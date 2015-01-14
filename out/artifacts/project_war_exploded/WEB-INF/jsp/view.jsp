<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Model.Role" %>
<%@ page import="Model.EmployeeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>List of all employees </h1>
    <%
        List l =(List) request.getAttribute("list");
        for(Iterator it = l.iterator(); it.hasNext();){
           EmployeeEntity e = (EmployeeEntity) it.next();
            out.println(e.getName());
            out.println(e.getUsername());
            out.print("<br>");
        }
    %>
</body>
</html>

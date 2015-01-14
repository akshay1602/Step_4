<%@ page import="java.util.List" %>
<%@ page import="java.util.Stack" %>
<%--
  Created by IntelliJ IDEA.
  User: akshay.Gupta
  Date: 1/14/2015
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>List of all subordinates </h1>
<%
    Stack<String> l =(Stack<String>) request.getAttribute("stack");

    while(!l.empty()){
        String s =l.pop();
        out.print(s);
        out.print("<br>");
    }
%>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1> Hey ${username} Enter the username of the employee to be deleted </h1>
    <form action="doDeletion.html" method="post">

        Username <br>
        <input type ="hidden" value="${username}" name="username">
        <input type="text" name="deletion_username">
        <input type="submit" value="Delete">
    </form>
</body>
</html>

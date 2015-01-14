
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1> Welcome ${message} </h1>

    <form method="post" action="edit.html">
        <input type="hidden" name = "username" value="${message}">
        <input type="submit" value = "edit">
    </form>

    <form method="post" action="view.html">
        <input type="hidden" name="username" value="${message}">
        <input type="submit" value = "view">
    </form>

    <form method="post" action="delete.html">
        <input type="hidden" name="username" value="${message}">
        <input type="submit" value = "delete">
    </form>

    <form method="post" action="signup.jsp">
        <input type="hidden" name="username" value="${message}">
        <input type="submit" value = "Create">
    </form>

    <form method="post" action="editManager.html">
        <input type="hidden" name="username" value="${message}">
        <input type="submit" value = "Edit_Manager">
    </form>

    <form method="post" action="subordinate.html">
        <input type="hidden" name="username" value="${message}">
        <input type="submit" value = "subordinates">
    </form>

</body>
</html>

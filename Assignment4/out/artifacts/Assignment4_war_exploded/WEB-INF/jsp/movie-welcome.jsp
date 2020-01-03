<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/19/2019
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h3>Welcome to out Movie Store</h3>
    <h4>Please make your selections below</h4>
    <form action="/hw4/movie" method="post">
        <select id="category" name="category">
            <option value="browse">Browse Movies</option>
            <option value="add">Add New Movie to Database</option>
        </select><br>
        <input type="submit" name="submit" value="send"></submit>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/19/2019
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <h3>Please enter the details below:</h3>
    <form action="/hw3/add">
        <input type="text" placeholder="Title" name="title"><br/>
        <input type="text" placeholder="Actor" name="actor"><br/>
        <input type="text" placeholder="Actress" name="actress"><br/>
        <input type="text" placeholder="Genre" name="genre"><br/>
        <input type="number" min="1900" max="2019" step="1" placeholder="2019" name="year">
        <input type="submit" name="add" value="Add Movie">
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/20/2019
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
    <h3>Please enter the details below:</h3>
    <form action="/hw4/search">
        Keyword: <input type="text" name="keyword"><br/>
        <input type="radio" value="title" name="type" checked="">Search By Tile<br/>
        <input type="radio" value="actor" name="type">Search By Actor<br/>
        <input type="radio" value="actress" name="type">Search By Actress<br/>
        <input type="radio" value="genre" name="type">Search By Genre<br/>
        <input type="radio" value="year" name="type">Search By Year<br/>
        <input type="submit" name="search" value="Search Movies">
    </form>
</body>
</html>

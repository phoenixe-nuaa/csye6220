<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/20/2019
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h3>You search for <c:out value="${type}"></c:out></h3>
    <h4>Here are the search results</h4>
    <c:forEach items="${data}" var="data">
        <table>
            <tr><td>Movie Tile: <th>${data.getTitle()}
            <tr><td>Actor:  <th>${data.getActor()}
            <tr><td>Actress:  <th>${data.getActress()}
            <tr><td>Genre: <th>${data.getGenre()}
            <tr><td>Year: <th>${data.getYear()}
        </table>
    </c:forEach>
    <p><a href="/hw3/movie">Return to the main page</a></p>
</body>
</html>

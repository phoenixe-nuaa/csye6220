<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/23/2019
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form action="/hw3/bookadd">
        <table>
            <tr>
                <th>ISBN</th>
                <th>Book Title</th>
                <th>Authors</th>
                <th>Price</th>
            </tr>
            <c:forEach var="i" begin="1" end="${num}">
                <tr>
                    <td><input type="text" name="${i}">
                    <td><input type="text" name="${i}">
                    <td><input type="text" name="${i}">
                    <td><input type="text" name="${i}">
                </tr>
            </c:forEach>
        </table>
        </tr>
        <input type="submit" name="submit" value="Add Books"></submit>
    </form>

</body>
</html>

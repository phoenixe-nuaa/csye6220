<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/23/2019
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
    <h3><c:out value="${content}"></c:out></h3>
    <p><a href="/hw4/book">Return to the main page</a></p>
</body>
</html>

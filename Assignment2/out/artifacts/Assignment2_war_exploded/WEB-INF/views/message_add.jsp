<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Message</title>
    <h4 align="center">The following item has been added to your shopping cart successfully</h4>
</head>
<body>
    <c:forEach items="${added}" var="elem">
        <p align="center"><c:out value="${elem}" /> </p>
    </c:forEach>
    <p align="center"><a href="?type=cart">View Cart</a></p>
</body>
</html>

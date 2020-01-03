<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart</title>
    <h4 align="center">These items are in your cart:</h4>
</head>
<body>
<c:choose>
    <c:when test="${empty cart}">
        <p align="center">Your cart is Empty</p>
    </c:when>
    <c:otherwise>
    <form align="center" class="content" action="shop" method="post">
        <div class="items">
            <c:forEach items="${cart}" var="elem">
                <c:out value="${elem.value}" /> <c:out value="${elem.key}" /> Select<input type="number" name="${elem.key}" value="0">to remove<br/>
            </c:forEach>
        </div>

        <div class="submit">
            <input type="submit" name="remove" value="Remove" />
        </div>
    </form>
    </c:otherwise>
</c:choose>
<p align="center"><a href="?type=book">Return</a></p>
</body>
</html>


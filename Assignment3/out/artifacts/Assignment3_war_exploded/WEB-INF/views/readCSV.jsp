<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/16/2019
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ReadCSV</title>
</head>
<body>
    <h3 align="center">SalesOrder</h3>
    <table align="center" border="1">
        <th>OrderID<th>OrderNumber<th>PurchaseOrderNumber
        <c:forEach items="${orderID}" var="elem">
            <tr><td><c:out value="${elem[0]}"/><th><c:out value="${elem[1]}"/><th><c:out value="${elem[2]}"/>
        </c:forEach>
    </table>
</body>
</html>

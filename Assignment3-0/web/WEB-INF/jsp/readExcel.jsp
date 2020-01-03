<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/18/2019
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ReadExcel</title>
</head>
<body>
    <h3 align="center">SalesOrder</h3>
    <table align="center" border="1">
        <c:forEach items="${store}" var="row">
            <tr>
                <c:forEach items="${row}" var="data">
                <th><c:out value="${data}"></c:out>
                </c:forEach>
        </c:forEach>
    </table>
</body>
</html>

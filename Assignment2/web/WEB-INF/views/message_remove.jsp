<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Message</title>
<h4 align="center">The following item have been removed from your shopping cart successfully</h4>
</head>
<body>
    <c:forEach items="${removed}" var="elem">
        <p align="center"><c:out value="${elem.value}" /> of <c:out value="${elem.key}" /></p>
    </c:forEach>
    <p align="center"><a href="?type=cart">View Cart</a></p>
</body>
</html>

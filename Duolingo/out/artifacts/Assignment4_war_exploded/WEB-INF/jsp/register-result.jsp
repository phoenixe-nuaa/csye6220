<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<c:if test="${content==true}">
    <h3>You are signed up successfully!</h3>
    <p><a href="/duo/login">Back to Log In</a></p>
</c:if>
<c:if test="${content==false}">
    <h3>Unfortunately registration fails... Please try again</h3>
    <p><a href="/duo/register">Back to Sign up</a></p>
</c:if>
</body>
</html>

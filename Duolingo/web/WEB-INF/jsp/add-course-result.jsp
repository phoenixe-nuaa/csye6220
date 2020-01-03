<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Course Result</title>
</head>
<body>
<c:if test="${content==true}">
    <h3>The Course is added successfully!</h3>
    <p><a href="/duo/manage-courses">Back to Manage Courses</a></p>
</c:if>
<c:if test="${content==false}">
    <h3>Unfortunately adding course fails... Please try again</h3>
    <p><a href="/duo/add-courses">Back to Add Courses</a></p>
</c:if>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/23/2019
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h3>Please enter the name of csv file</h3>
    <form action="/hw3/csv.xls" method="post">
        <input type="text" name="filename">
        <input type="submit" name="submit" value="Enter">
    </form>
</body>
</html>

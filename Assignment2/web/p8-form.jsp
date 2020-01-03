<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="form" class="neu.edu.csye6220.p8.FormBean" scope="request" />
<%--    <jsp:setProperty name="form" property="email" param="email"/>--%>
<%--    <jsp:setProperty name="form" property="password" value="123"/>--%>
<%--    <jsp:setProperty name="form" property="confirm_password" param="confirm_password"/>--%>
<%--    <jsp:setProperty name="form" property="gender" param="gender"/>--%>
<%--    <jsp:setProperty name="form" property="country" param="country"/>--%>
<%--    <jsp:setProperty name="form" property="hobby" param="hobby"/>--%>
<%--    <jsp:setProperty name="form" property="address" param="address"/>--%>
    <jsp:setProperty name="form" property="*"></jsp:setProperty>
<html>
<head>
    <title>Info</title>
</head>
<body>

    <h2 align="center">Hello, here is the summary of your info</h2>
    <table align="center" border="1">
        <th><th>Details
        <tr><td>email<th><jsp:getProperty name="form" property="email"></jsp:getProperty>
        <tr><td>password<th><jsp:getProperty name="form" property="password"></jsp:getProperty>
        <tr><td>gender<th><jsp:getProperty name="form" property="gender"></jsp:getProperty>
        <tr><td>country<th><jsp:getProperty name="form" property="country"></jsp:getProperty>
        <c:set var="hobby" value="${form.hobby}" />
        <tr><td>hobby<th>${fn:join(hobby,', ')}
<%--        <tr><td>hobby<th><jsp:getProperty name="form" property="hobby"></jsp:getProperty>--%>
        <tr><td>address<th><jsp:getProperty name="form" property="address"></jsp:getProperty>
    </table>
</body>
</html>
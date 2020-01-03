<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/9/2019
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<TABLE BORDER>
<H3>Sorry, you must log in before accessing this resource.</H3>
<FORM ACTION="j_security_check" METHOD="POST">
    <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username"><br/>
    <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password"><br/>
    <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In"><br/>
</TH>
</FORM>
</body>
</html>

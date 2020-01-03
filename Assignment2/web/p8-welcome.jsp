<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <h1>Registration Form</h1>
</head>
<body>
<form method="post" action="p8-form.jsp">
    Email: <input type="mail" name="email"><br>
    Password: <input type="password" name="password"><br>
    Confirm Password: <input type="password" name="confirm_password"><br>
    Upload Your Picture: <input type="file" name="photo"><br>
    Gender:<input type="radio" value="male" name="gender">Male
    <input type="radio" value="female" name="gender">Female<br>
    <label for="country">Select Country: </label>
    <!-- <span style="color: red !important; display: inline; float: none;">*</span>       -->
    <select id="country" name="country" class="form-control">
        <option value="united states">United States</option>
        <option value="china">China</option>
        <option value="other">Other</option>
    </select><br>
    Hobby:<input type="checkbox" name="hobby" value="cricket">Cricket
    <input type="checkbox" name="hobby" value="football">Football<br>
    Address:<textarea rows="4" cols="25" name="address"></textarea><br>
    <input type="submit" name="submit">
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>

</head>
<body>
<table border="1">
    <h3>Please complete your info below</h3>
    <form method="post" action="/duo/register" enctype="multipart/form-data">
        Username: <input type="text" name="username"/><br>
        Email: <input type="mail" name="email"><br>
        Password: <input type="password" name="password"><br>
        Age: <input type="number" name="age"/><br>
        Gender:<input type="radio" value="male" name="gender">Male
        <input type="radio" value="female" name="gender">Female<br>
        <label for="country">Select Country: </label>
        <!-- <span style="color: red !important; display: inline; float: none;">*</span>       -->
        <select id="country" name="country" class="form-control">
            <option value="united states">United States</option>
            <option value="china">China</option>
            <option value="other">Other</option>
        </select><br>
        Location:<textarea rows="4" cols="25" name="location"></textarea><br>
        <input type="submit" name="submit">
    </form>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
    <style>
        .tabs {
            height: 100%; /* Full-height: remove this if you want "auto" height */
            width: 160px; /* Set the width of the sidebar */
            position: fixed; /* Fixed Sidebar (stay in place on scroll) */
            z-index: 1; /* Stay on top */
            top: 0; /* Stay at the top */
            left: 0;
            /* background-color: #111; /* Black */
            overflow-x: hidden; /* Disable horizontal scroll */
            padding-top: 20px;
        }
        .main {
            margin-top: 20px;
            margin-left: 200px; /* Same as the width of the sidebar */
            padding: 20px 20px;
        }
    </style>
</head>
<body>
    <div class="main">
        <h3>Here are the registered users</h3>
        <table>
            <tr>
                <td>Username</td>
                <td>Email</td>
                <td>Age</td>
                <td>Gender</td>
                <td>Country</td>
                <td>Location</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <th>${user.getUsername()}</th>
                    <th>${user.getEmail()}</th>
                    <th>${user.getAge()}</th>
                    <th>${user.getGender()}</th>
                    <th>${user.getCountry()}</th>
                    <th>${user.getLocation()}</th>
                </tr>
            </c:forEach>
        </table>

    </div>
    <div class="tabs">
        <p><a href="/duo/manage-courses" onclick="">Manage Courses</a></p>
        <p><a href="/duo/manage-users" onclick="">Manage Users</a></p>
        <p><a href="/duo/account" onclick="">Account</a></p>
        <p><a href="/duo/profile" onclick="">Profile</a></p>
        <p><a href="/duo/photo" onclick="">Photo</a></p>
        <p><a href="/duo/privacy" onclick="">Privacy</a></p>
    </div>
</body>
</html>

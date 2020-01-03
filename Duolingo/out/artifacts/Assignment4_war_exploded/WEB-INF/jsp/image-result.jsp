<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photo</title>
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
    <c:if test="${not empty message}">
        ${message}
    </c:if>
</div>
<div class="tabs">
    <p><a href="/duo/courses" onclick="">Courses</a></p>
    <p><a href="/duo/leaderboard" onclick="">Leaderboard</a></p>
    <p><a href="/duo/account" onclick="">Account</a></p>
    <p><a href="/duo/profile" onclick="">Profile</a></p>
    <p><a href="/duo/photo" onclick="">Photo</a></p>
    <p><a href="/duo/privacy" onclick="">Privacy</a></p>
</div>
</body>
</html>

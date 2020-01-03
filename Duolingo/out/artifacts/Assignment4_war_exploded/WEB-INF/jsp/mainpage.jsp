<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MainPage</title>
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
    <c:if test="${category==1}">
        <h2><c:out value="${content}"></c:out></h2>
        <p><a href="/duo/register" onclick="">Back to Sign Up</a></p>
    </c:if>
    <c:if test="${category==2}">
        <h2><c:out value="${content}"></c:out></h2>
        <p><a href="/duo/login" onclick="">Back to Log In</a></p>
    </c:if>
    <c:if test="${category>=3}">
        <div class="main">
            <h3>Welcome, <c:out value="${username}"></c:out></h3>
        </div>
        <div class="tabs">
            <c:if test="${category==3}">
                <p><a href="/duo/courses" onclick="">Courses</a></p>
                <p><a href="/duo/leaderboard" onclick="">Leaderboard</a></p>
            </c:if>
            <c:if test="${category==4}">
                <p><a href="/duo/manage-courses" onclick="">Manage Courses</a></p>
                <p><a href="/duo/manage-users" onclick="">Manage Users</a></p>
            </c:if>
            <p><a href="/duo/account" onclick="">Account</a></p>
            <p><a href="/duo/profile" onclick="">Profile</a></p>
            <p><a href="/duo/photo" onclick="">Photo</a></p>
            <p><a href="/duo/privacy" onclick="">Privacy</a></p>
        </div>
    </c:if>
</body>
</html>

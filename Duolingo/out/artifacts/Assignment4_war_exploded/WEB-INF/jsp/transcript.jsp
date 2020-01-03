<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Transcript</title>
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
        .item {
            padding: 20px 20px;
        }
    </style>
</head>
<body>
<div class="main">
    <h3>Ta-da! You are making much progress!</h3>
    <c:forEach items="${result}" var="data">
        <div class="item">
            <table>
                <tr><td>Course Name: <th>${data.getCoursename()}
                <tr><td>Score: <th>${data.getScore()}
            </table>
        </div>
    </c:forEach>
    <p><a href="/duo/mainpage" onclick="">Back to Home</a></p>
</div>
<div class="tabs">
    <p><a href="/duo/my-courses" onclick="">My Courses</a></p>
    <p><a href="/duo/all-courses" onclick="">Enroll in New Courses</a></p>
    <p><a href="/duo/transcript" onclick="">My transcript</a></p>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Courses</title>
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
    <h3>You are several courses away from a duolingo master</h3>
    <c:forEach items="${courses}" var="course">
        <form action="learn" method="post">
            <table>
                <tr><td>Course Name: <th>${course.getCoursename()}
                <tr><td>Language: <th>${course.getWhichlanguage()}
                <tr><td>Level: <th>${course.getWhichlevel()}
            </table>
            <input type="hidden" name="courseName" value="${course.getCoursename()}"/>
            <input type="submit" name="submit" value="Learn">
        </form>
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

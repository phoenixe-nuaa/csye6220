<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Courses Result</title>
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
        <c:if test="${result==true}">
            <h3>You have enrolled in all courses. Explore another language!</h3>
            <p><a href="/duo/courses" onclick="">Back</a></p>
        </c:if>
        <c:if test="${result==false}">
            <form method="post" action="/duo/all-courses-enroll">
                <c:forEach items="${data}" var="data">
                    <input type="checkbox" name="courses" value="${data.getCoursename()}">
                    <table>
                        <tr><td>Course Name: <th>${data.getCoursename()}
                        <tr><td>Language: <th>${data.getWhichlanguage()}
                        <tr><td>Level: <th>${data.getWhichlevel()}
                    </table>
                </c:forEach>
                <input type="submit" name="enroll" value="Enroll"/>
            </form>
        </c:if>
</div>
<div class="tabs">
    <p><a href="/duo/my-courses" onclick="">My Courses</a></p>
    <p><a href="/duo/all-courses" onclick="">Enroll in New Courses</a></p>
    <p><a href="/duo/transcript" onclick="">My transcript</a></p>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Courses</title>
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
    <h3>Excellent! Boost yourself with more courses</h3>
    <form method="post" action="/duo/all-courses">
        <label for="language">Select Language: </label>
        <!-- <span style="color: red !important; display: inline; float: none;">*</span>       -->
        <select id="language" name="language">
            <option value="french">French</option>
            <option value="german">German</option>
            <option value="spanish">Spanish</option>
        </select><br>
        <input type="hidden" name="category" value="search">
        <input type="submit" name="search" value="Search">
    </form>
</div>
<div class="tabs">
    <p><a href="/duo/my-courses" onclick="">My Courses</a></p>
    <p><a href="/duo/all-courses" onclick="">Enroll in New Courses</a></p>
    <p><a href="/duo/transcript" onclick="">My transcript</a></p>
</div>
</body>
</html>

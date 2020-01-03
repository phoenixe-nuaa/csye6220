<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Courses</title>
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
    <h3>Choose which type for keyword search:</h3>
    <form method="post" action="/duo/search-courses">
        <label for="type">Select type: </label>
        <!-- <span style="color: red !important; display: inline; float: none;">*</span>       -->
        <select id="type" name="type">
            <option value="language">Language</option>
            <option value="level">Level</option>
            <option value="coursename">Course Name</option>
        </select><br>
        Enter the keyword:<input type="text" name="keyword"/><br>
        <input type="submit" name="search" value="Search">
    </form>
</div>
<div class="tabs">
    <p><a href="/duo/add-courses" onclick="">Add Courses</a></p>
    <p><a href="/duo/search-courses" onclick="">Search Courses</a></p>
</div>
</body>
</html>

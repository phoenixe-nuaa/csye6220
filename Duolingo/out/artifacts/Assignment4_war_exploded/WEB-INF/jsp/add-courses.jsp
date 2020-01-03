<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Courses</title>
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
        <table border="1">
            <h3>Welcome to add-courses page</h3>
            <form action="add-courses" method="post">
                <tr><td>Course Name: <input type="text" name="coursename"><br/>
                <tr><td>Language: <input type="text" name="language"><br/>
                <tr><td>Level: <input type="number" name="level"><br/>
<%--                <tr><td>Number of Tasks: <input type="number" name="tasks"><br/>--%>
                <tr><th><input type="submit" value="Add"><br/>
                </th>
            </form>
        </table>
        <p><a href="/duo/mainpage" onclick="">Back to Home</a></p>
    </div>
    <div class="tabs">
        <p><a href="/duo/add-courses" onclick="">Add Courses</a></p>
        <p><a href="/duo/search-courses" onclick="">Search Courses</a></p>
    </div>
</body>
</html>

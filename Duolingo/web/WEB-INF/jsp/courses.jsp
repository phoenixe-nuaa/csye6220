<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
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
    <h3>Feeling 100% today? Duolingo is waiting</h3><br>
</div>
<div class="tabs">
    <p><a href="/duo/my-courses" onclick="">My Courses</a></p>
    <p><a href="/duo/all-courses" onclick="">Enroll in New Courses</a></p>
    <p><a href="/duo/transcript" onclick="">My transcript</a></p>
</div>
</body>
</html>

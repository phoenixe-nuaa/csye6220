<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basics 1</title>
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
        .q1 {
            padding: 20px 20px;
        }
        .q2 {
            padding: 20px 20px;
        }
        .q3 {
            padding: 20px 20px;
        }
        .q4 {
            padding: 20px 20px;
        }
        .q5 {
            padding: 20px 20px;
        }
    </style>
</head>
<body>
<div class="tabs">
    <p><a href="/duo/my-courses" onclick="">My Courses</a></p>
    <p><a href="/duo/all-courses" onclick="">Enroll in New Courses</a></p>
    <p><a href="/duo/transcript" onclick="">My transcript</a></p>
</div>
<div class="main">
    <h3>Welcome to Basics 1</h3>
    <form action="basics1" method="post">
        <div class="q1">
            <label>1. Which one of these means "yes":</label><br>
            <input type="radio" name="question1" value="oui">Oui<br>
            <input type="radio" name="question1" value="na">Na<br>
            <input type="radio" name="question1" value="non">Non<br>
        </div>
        <div class="q2">
            <label>2. Please translate the following sentence:</label><br>
            <label>Hello, My name is Tom.</label><br>
            <input type="text" name="question2"><br>
        </div>
        <div class="q3">
            <label>3. Which one of these is "hello":</label><br>
            <input type="radio" name="question3" value="hola">Hola<br>
            <input type="radio" name="question3" value="bonjour">Bonjour<br>
            <input type="radio" name="question3" value="halo">Halo<br>
        </div>
        <div class="q4">
            <label>4. What's the following sentence in French:</label><br>
            <label>How are you.</label><br>
            <input type="text" name="question4"><br>
        </div>
        <div class="q5">
            <label>5. Which one of these is "I":</label><br>
            <input type="radio" name="question5" value="a">Toi<br>
            <input type="radio" name="question5" value="b">Il<br>
            <input type="radio" name="question5" value="c">Je<br>
        </div>
        <input type="submit" name="submit" value="Submit Your Answer">
    </form>
</div>
</body>
</html>

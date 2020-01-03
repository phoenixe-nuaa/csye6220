<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basics 2</title>
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
    <h3>Welcome to Basics 2</h3>
    <form action="basics2" method="post">
        <div class="q1">
            <label>1. Which one of these means "goodbye":</label><br>
            <input type="radio" name="question1" value="a">Au Revoir<br>
            <input type="radio" name="question1" value="b">Bonne Nuit<br>
            <input type="radio" name="question1" value="c">Bonsoir<br>
        </div>
        <div class="q2">
            <label>2. Please translate the following sentence to French:</label><br>
            <label>Welcome.</label><br>
            <input type="text" name="question2"><br>
        </div>
        <div class="q3">
            <label>3. Which one of these is "Thank you":</label><br>
            <input type="radio" name="question3" value="a">Merci<br>
            <input type="radio" name="question3" value="b">De Rien<br>
            <input type="radio" name="question3" value="c">Excusez-moi<br>
        </div>
        <div class="q4">
            <label>4. Please write this in French:</label><br>
            <label>Good night.</label><br>
            <input type="text" name="question4"><br>
        </div>
        <div class="q5">
            <label>5. Which one of these is "You're welcome":</label><br>
            <input type="radio" name="question5" value="a">Merci<br>
            <input type="radio" name="question5" value="b">De Rien<br>
            <input type="radio" name="question5" value="c">Excusez-moi<br>
        </div>
        <input type="submit" name="submit" value="Submit Your Answer">
    </form>
</div>
</body>
</html>

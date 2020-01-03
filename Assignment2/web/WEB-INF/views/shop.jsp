<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Shopping Store</title>
<style>
    .sidenav {
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
        margin-top: 0px;
        margin-left: 200px; /* Same as the width of the sidebar */
        padding: 0px 20px;
    }
    .submit {
        margin-top: 10px;
    }
</style>
</head>
<body>
<div class="sidenav">
    <p><a href="?type=book" onclick="">Books</a></p>
    <p><a href="?type=music" onclick="">Music</a></p>
    <p><a href="?type=computers" onclick="">Computers</a></p>
    <p><a href="?type=cart" onclick="">View Cart</a></p>
</div>
<div class="main">
    <p id="subtitle">Shop for Fun!!</p>
    <form class="content" action="shop" method="post">
        <div class="items">
            <c:forEach items="${items.item}" var="elem">
                <input type="checkbox" name="item" value="${elem}"><c:out value="${elem}" /> <br/>
            </c:forEach>
        </div>
        <div class="submit">
            <input type="submit" name="add" value="Add to Cart" />
        </div>
    </form>
</div>
</body>
</html>

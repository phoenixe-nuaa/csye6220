<%--
  Created by IntelliJ IDEA.
  User: Chen.JL
  Date: 10/8/2019
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--- <c:forEach></c:forEach>--%>
<%--- <c:out></c:out>--%>
<%--- <c:if></c:if>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--- <fn:toLowerCase></fn:toLowerCase>--%>
<%--- <fn:toUpperCase></fn:toUpperCase>--%>
<%--- <fn:substringAfter></fn:substringAfter>--%>
<%--- <fn:substringBefore></fn:substringBefore>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--- <fmt:formatNumber></fmt:formatNumber>--%>
<%--- <fmt:formatDate></fmt:formatDate>--%>
<%--- <fmt:setTimeZone></fmt:setTimeZone>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%--<x:set></x:set>--%>
<%--<x:out></x:out>--%>
<%--<x:parse></x:parse>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--<sql:setDataSource></sql:setDataSource>--%>
<%--<sql:update></sql:update>--%>
<%--<sql:query></sql:query>--%>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <c:set var="str1" value="hello, welcome to the Shopping Cart!"/>
    <c:set var="str2" value="${fn:substringAfter(str1, \"hello,\")}"/>
    <c:set var="str3" value="${fn:substringBefore(str1, str2)}"/>
    ${fn:toUpperCase(str3)}
    ${fn:toLowerCase(str2)}
    <h3>Shopping Cart</h3>
    <ul>
        <h4>Books</h4>
        <c:forEach var="i" begin="1" end="10">
        <c:if test="${i%2==1}">
            <li> Book<c:out value="${i}"></c:out>
            <fmt:formatNumber value="${i}" type="number" pattern="$##.##"/> <br/>
        </c:if>
        </c:forEach>
    </ul>
    <sql:setDataSource var = "cds" driver = "com.mysql.jdbc.Driver"
                       url = "jdbc:mysql://localhost/test"
                       user = "root"  password = "root"/>

    <sql:update dataSource="${cds}" var = "result1">
        INSERT INTO test.CDs VALUES ('CD6', 6);
<%--        DELETE FROM test.CDs WHERE name = 'CD6'--%>
    </sql:update>
    <sql:query dataSource = "${cds}" var = "result">
        SELECT * from test.CDs;
    </sql:query>
    <ul>
        <h4>CDs</h4>
        <c:forEach var = "row" items = "${result.rows}">
            <li><td> <c:out value = "${row.name}"/></td>
                <td> <fmt:formatNumber value="${row.price}" type="number" pattern="$##.##"/></td>
        </c:forEach>
    </ul>
    <c:set var="books">
        <books>
            <book>
                <name>The Great Gatsby</name>
                <author>F. Scott Fitzgerald</author>
            </book>
            <book>
                <name>Romeo and Juliet</name>
                <author>William Shakespeare</author>
            </book>
            <book>
                <name>The Old Man and The Sea</name>
                <author>Ernest Hemingway</author>
            </book>
        </books>
    </c:set>
    <x:parse xml="${books}" var="output"/>
        <b>Name of the book Recommended for you</b>:
        <x:out select="$output/books/book[1]/name"/><br/>
        <b>Author of the book is</b>:
        <x:out select="$output/books/book[1]/author"/><br/>
    <x:set var="myfav" select="$output/books/book[2]/name"/>

    <c:set var="str" value="<%=new java.util.Date()%>"/>
    <fmt:setTimeZone value="GMT-5"/>
    <hr/>
    Current Time in Boston: <fmt:formatDate value="${str}" timeStyle="long" dateStyle="long" type="both"/>
</body>
</html>

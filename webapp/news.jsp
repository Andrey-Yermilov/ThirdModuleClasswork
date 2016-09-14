<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News</title>
</head>
<body>
<p>Hi, ${name} ${surname}</p>
<hr/>
<c:forEach var="news" items="${allNews}">
    <h3><c:out value="${ news.title }"/></h3>
    <c:out value="${ news.author }"/> -
    <c:out value="${ news.date }"/>
    <hr/>
    <c:out value="${ news.body }"/>
    <hr/>
</c:forEach>

<a href="index.jsp">Create news</a>

</body>
</html>

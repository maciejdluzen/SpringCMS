<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Authors</title>
</head>
<body>
<table>
    <tr>
        <th>No.</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach items="${authors}" var="author" varStatus="stat">
        <tr>
            <th>${stat.count}</th>
            <th>${author.firstName}</th>
            <th>${author.lastName}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>

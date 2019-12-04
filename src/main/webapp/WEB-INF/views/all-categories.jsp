<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All categories</title>
</head>
<body>
<table>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${categories}" var="category" varStatus="stat">
        <tr>
            <th>${stat.count}</th>
            <th>${category.name}</th>
            <th>${category.description}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>

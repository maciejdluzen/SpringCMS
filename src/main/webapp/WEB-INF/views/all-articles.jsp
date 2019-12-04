<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Articles</title>
</head>
<body>
<table>
    <tr>
        <th>No.</th>
        <th>Title</th>
        <th>Content</th>
        <th>Category</th>
        <th>Author</th>
        <th>Created</th>
        <th>Updated</th>
    </tr>
    <for:forEach items="${articles}" var="article" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>
                <ol>
                    <for:forEach items="${article.categories}" var="category">
                        <li>${category.name}</li>
                    </for:forEach>
                </ol>
            </td>
            <td>${article.author.firstName}</td>
            <td>${article.createdOn}</td>
            <td>${article.updatedOn}</td>
        </tr>
    </for:forEach>
</table>
</body>
</html>

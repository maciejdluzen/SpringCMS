<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <p><form:hidden path="id"/></p>
    <p>Title: <form:input path="title"/></p>
    <p>Content <form:input path="content"/></p>
    <p>Category <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"/></p>
    <p>Author <form:select path="author" items="${authors}" itemLabel="firstName" itemValue="id"/></p>
    <p><input type="submit" value="Submit"></p>
</form:form>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <p><form:hidden path="id"/></p>
    <p>Name: <form:input path="name"/></p>
    <p>Description: <form:input path="description"/></p>
    <p><input type="submit" value="Submit"></p>
</form:form>
</body>
</html>

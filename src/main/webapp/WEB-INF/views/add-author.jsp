<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 04/12/2019
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <p><form:hidden path="id"/></p>
    <p>First Name: <form:input path="firstName"/></p>
    <p>Last Name: <form:input path="lastName"/></p>
    <p><input type="submit" value="Submit"></p>
</form:form>
</body>
</html>

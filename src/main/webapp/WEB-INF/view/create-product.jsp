<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sidor
  Date: 29.11.2021
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<%--@elvariable id="product" type="ru.gb.entity.Product"--%>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:input path="title"/>
    <br>
    Cost: <form:input path="cost"/>
    <br>
    <input type="submit" value="submit">
</form:form>
</body>
</html>

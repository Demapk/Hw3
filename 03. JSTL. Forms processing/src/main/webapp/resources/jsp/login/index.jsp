<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Логин</h1>
<c:if test="${param.error ne null}">
    <h2>Неправильные данные</h2>
</c:if>
<form action="/login_process" method="post">
    <label>Логин
        <input type="text" name="username">
    </label>
    <label>
        <input type="password" name="password">
    </label>
    <input type="submit">
</form>
</body>
</html>
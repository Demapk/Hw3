<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<security:authorize access="hasRole('USER')">
    <a href="/calculator">Посчитать</a> <br>
    <form method="post" action="/logout">
        <button type="submit">Logout</button>
    </form>
</security:authorize>
<security:authorize access="isAnonymous()">
    <a href="/registration">Регистрация</a> <br>
    <a href="/login">Логин</a> <br>
</security:authorize>
<a href="/operations">Посмотреть историю операций</a>
</body>
</html>

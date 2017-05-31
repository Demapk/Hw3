<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1>
<sf:form action="/registration" method="post" modelAttribute="user">
    <sf:label path="username">Login: </sf:label> <sf:input  path="username"/><sf:errors path="username"/>
    <br>
    <sf:label path="password">password: </sf:label> <sf:input type="password" path="password"/><sf:errors path="password"/>
    <br>
    <sf:label path="matchingPassword">repassword: </sf:label> <sf:input type="password" path="matchingPassword"/><sf:errors path="matchingPassword"/>
    <br>
    <button type="submit">Регистрация</button>
</sf:form>
</body>
</html>

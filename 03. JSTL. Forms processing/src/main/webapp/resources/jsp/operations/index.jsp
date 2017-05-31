<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Операции</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<table>
    <tr>
        <th>Дата</th>
        <th>Первое число</th>
        <th>Операнд</th>
        <th>Второе число</th>
        <th>Результат</th>
    </tr>

    <c:forEach var="operation" items="${operations}">
        <tr>
            <td>${operation.date}</td>
            <td>${operation.calculator.firstNumber}</td>
            <td> ${operation.calculator.operation}</td>
            <td>${operation.calculator.secondNumber}</td>
            <td> ${operation.calculator.result}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

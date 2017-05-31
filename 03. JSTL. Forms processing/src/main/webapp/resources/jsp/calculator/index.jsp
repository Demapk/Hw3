<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тест</title>
</head>
<body>
<sf:form action="/calculator" method="post" modelAttribute="calculator">
    <sf:label path="firstNumber">First Number: </sf:label> <sf:input type="number" required="required" step="0.00001" path="firstNumber"/> <sf:errors path="firstNumber"/> <br>
    <sf:label path="secondNumber">Second Number: </sf:label> <sf:input type="number" required="required" step="0.00001" path="secondNumber"/> <sf:errors path="secondNumber"/><br>
    <sf:label path="operation">Operation: </sf:label> <sf:input maxlength="1" path="operation"/> <sf:errors path="operation"/><br>
    <button type="submit">Получить результат</button>
</sf:form>
<c:if test="${not empty result}">
    <h1>Результат: ${result}</h1>
</c:if>
</body>
</html>


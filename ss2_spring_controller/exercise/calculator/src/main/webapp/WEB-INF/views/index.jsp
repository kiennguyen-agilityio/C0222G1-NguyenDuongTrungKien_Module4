<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/6/2022
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1> Calculator Simple </h1>
<form action="/calculator" method="post">
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">

    <button type="submit" value="+" name="calculation">
        +
    </button>
    <button type="submit" value="-" name="calculation">
        -
    </button>
    <button type="submit" value="*" name="calculation">
        *
    </button>
    <button type="submit" value="/" name="calculation">
        /
    </button>
    <div>
        <span>Result: ${result}</span></span>
    </div>
</form>
</body>
</html>

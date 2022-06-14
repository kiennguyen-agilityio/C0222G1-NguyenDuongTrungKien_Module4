<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/6/2022
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Currency </title>
</head>
<body>
<form action="/index" method="post">
    <p> Nhập vào số USD cần chuyển đổi </p>
    <input type="text" name="usd" value="${usd}">
    <p> Nhập tỉ giá </p>
    <input type="text" name="rate" value="${rate}">
    <input type="submit">
    <p> kết quả là ${result}</p>
</form>
</body>
</html>

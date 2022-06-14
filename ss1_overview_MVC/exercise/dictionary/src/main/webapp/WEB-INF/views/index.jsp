
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Convert Currency </title>
</head>
<body>
<form action="/index" method="post">
  <p> Nhập từ bạn muốn dịch </p>
  <input type="text" name="english" value="${eng}">
  <input type="submit">
  <p> kết quả là ${result}</p>
</form>
</body>
</html>

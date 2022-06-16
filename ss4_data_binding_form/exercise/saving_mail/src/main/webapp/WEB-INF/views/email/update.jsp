<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/6/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form action="saveEmail" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language"> Languages </form:label></td>
            <td>
                <form:select path="language">
                    <form:option value="English"/>
                    <form:option value="Vietnamese"/>
                    <form:option value="Japanese"/>
                    <form:option value="Chinese"/>
                    <form:options items="${languageList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size</form:label></td>
            <td>Show
                <form:select path="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                emails per page
            </td>
        <tr>
            <td><form:label path="spamFilters">Spam filter</form:label></td>
            <td>
                <form:checkbox path="spamFilters"/>
                <form:label path="spamFilters">Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>
</body>
</html>

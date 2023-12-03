<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruit List</title>
</head>
<body>
    <h1>Fruit List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="fruit" items="${fruits}">
                <tr>
                    <td>${fruit.id}</td>
                    <td>${fruit.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

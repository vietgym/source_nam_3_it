<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý bệnh nhân</title>
</head>
<body>
    <h1>Danh sách bệnh nhân</h1>
    <table border = 1>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên bệnh nhân</th>
                <th>Phí viện phí</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.name}</td>
                    <td>${patient.hospitalfee}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

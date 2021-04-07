<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: romuloandrade
  Date: 02/04/2021
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>

    <h1>Companies</h1>

    <c:if test="${not empty companies}">
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${companies}" var="company">
                    <tr>
                        <td>${company.name}</td>
                        <td><fmt:formatDate value="${company.createdAt}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                        <td>
                            <a href="show-company?id=${company.id}">edit</a>
                            <a href="remove-company?id=${company.id}">remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty companies}">
            <p>No registered companies so far</p>
    </c:if>

</body>
</html>



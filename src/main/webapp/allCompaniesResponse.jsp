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
        <ul>
            <c:forEach items="${companies}" var="company">
                <li>
                    ${company.name} -
                    <fmt:formatDate value="${company.createdAt}" pattern="dd/MM/yyyy"></fmt:formatDate>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty companies}">
            <p>No registered companies so far</p>
    </c:if>

</body>
</html>



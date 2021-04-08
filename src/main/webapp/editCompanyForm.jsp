<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Company</title>
</head>
<body>

    <h1>Update Company</h1>

    <c:url value="/router" var="routerPath" />
    <form action="${routerPath}" method="post">
        <input type="hidden" name="id" value="${company.id}">
        <input type="hidden" name="action" value="update-company">

        <label>
            Name:
            <input required type="text" name="name" value="${company.name}">
        </label>

        <br>

        <label>
            Creation Date:
            <input required type="text" name="date" value="<fmt:formatDate value="${company.createdAt}" pattern="dd/MM/yyyy"></fmt:formatDate>">
        </label>

        <br>

        <input type="submit">
    </form>

</body>
</html>
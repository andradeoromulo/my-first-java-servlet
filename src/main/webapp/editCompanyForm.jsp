<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Company</title>
</head>
<body>

    <h1>Create new Company</h1>

    <c:url value="/edit-company" var="newCompanyServlet" />
    <form action="${newCompanyServlet}" method="post">
        <input required type="hidden" name="id" value="${company.id}">

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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Company</title>
</head>
<body>

    <h1>Create new Company</h1>

    <c:url value="/new-company" var="newCompanyServlet" />
    <form action="${newCompanyServlet}" method="post">
        <label>
            Name:
            <input required type="text" name="name">
        </label>

        <br>

        <label>
            Creation Date:
            <input required type="text" name="date">
        </label>

        <br>

        <input type="submit">
    </form>

</body>
</html>
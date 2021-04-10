<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Company</title>
</head>
<body>

    <h1>Create new Company</h1>

    <form action="router?action=CreateCompany" method="post">
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

    <c:import url="sessionInformationScript.jsp" />

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

    <h1>Login</h1>

    <form action="router?action=Authenticate" method="post">
        <label>
            Login:
            <input required type="text" name="login">
        </label>

        <br>

        <label>
            Password:
            <input required type="password" name="password">
        </label>

        <br>

        <input type="submit">
    </form>

</body>
</html>
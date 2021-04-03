<%--
  Created by IntelliJ IDEA.
  User: romuloandrade
  Date: 02/04/2021
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    // Could get the parameter directly from request
    //String companyName = request.getParameter("name");
    // Or get an attribute appended to request
    // String companyName = (String) request.getAttribute("companyName");
    // Or I can finally access it via Expression Language, just like below
%>
<html>
<head>
    <title>Create new Company</title>
</head>
<body>

    <h1>New company successfully created.</h1>
    <h2>${ companyName }</h2>

</body>
</html>

<%@ page import="com.example.my_first_java_servlet.Company" %>
<%@ page import="java.util.List" %>
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
    <ul>

    <%
        List<Company> companies = (List) request.getAttribute("companies");

        if(companies.size() == 0) {
    %>
        <p>No registered companies so far</p>
    <%
        } else {
            for (Company company : companies) {
    %>
        <li><%= company.getNome() %></li>
    <%
            }
        }
    %>

    </ul>

</body>
</html>
}


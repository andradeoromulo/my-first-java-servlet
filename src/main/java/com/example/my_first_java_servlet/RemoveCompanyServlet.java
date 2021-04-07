package com.example.my_first_java_servlet;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveCompanyServlet", value = "/remove-company")
public class RemoveCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int companyId = Integer.parseInt(request.getParameter("id"));

        Database db = new Database();
        db.removeById(companyId);

        response.sendRedirect("companies");

    }

}

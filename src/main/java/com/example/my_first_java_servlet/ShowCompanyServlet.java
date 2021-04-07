package com.example.my_first_java_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowCompanyServlet", value = "/show-company")
public class ShowCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int companyId = Integer.parseInt(request.getParameter("id"));

        Database db = new Database();
        Company company = db.findOne(companyId);

        request.setAttribute("company", company);

        RequestDispatcher rd = request.getRequestDispatcher("/editCompanyForm.jsp");
        rd.forward(request, response);

    }
}

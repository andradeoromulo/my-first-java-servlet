package com.example.my_first_java_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AllCompaniesServlet", value = "/companies")
public class AllCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {

        Database db = new Database();
        List<Company> companies = db.findAll();

        request.setAttribute("companies", companies);

        RequestDispatcher rd = request.getRequestDispatcher("/allCompaniesResponse.jsp");
        rd.forward(request, resp);

    }
}

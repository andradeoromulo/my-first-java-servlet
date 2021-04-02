package com.example.my_first_java_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewCompanyServlet", value = "/new-company")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String companyName = req.getParameter("name");
        Company newCompany = new Company(companyName);

        Database db = new Database();
        db.add(newCompany);

        req.setAttribute("companyName", newCompany.getNome());

        RequestDispatcher rd =  req.getRequestDispatcher("/newCompanyResponse.jsp");
        rd.forward(req, resp);

    }
}

package com.example.my_first_java_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NewCompanyServlet", value = "/new-company")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String companyName = req.getParameter("name");
        String companyCreatedAtInput = req.getParameter("date");

        Date companyCreatedAt = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            companyCreatedAt = sdf.parse(companyCreatedAtInput);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company newCompany = new Company(companyName, companyCreatedAt);

        Database db = new Database();
        db.add(newCompany);

        req.setAttribute("companyName", newCompany.getName());

        RequestDispatcher rd =  req.getRequestDispatcher("/newCompanyResponse.jsp");
        rd.forward(req, resp);

    }
}

package com.example.my_first_java_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditCompanyServlet", value = "/edit-company")
public class EditCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        int companyId = Integer.parseInt(req.getParameter("id"));
        String companyName = req.getParameter("name");
        String companyCreatedAtInput = req.getParameter("date");

        Date companyCreatedAt = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            companyCreatedAt = sdf.parse(companyCreatedAtInput);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company company = new Company(companyName, companyCreatedAt);

        Database db = new Database();
        db.updateOne(companyId, company);

        response.sendRedirect("companies");

    }

}

package com.example.my_first_java_servlet;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewCompanyServlet", value = "/new-company")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String companyName = req.getParameter("name");
        Company newCompany = new Company(companyName);

        Database db = new Database();
        db.add(newCompany);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>Create new company</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>New company successfully created.</h1>");
        out.println("<h2>" + companyName + "</h2>");

        out.println("</body>");
        out.println("</html>");

        System.out.println("Creating new company");
    }
}

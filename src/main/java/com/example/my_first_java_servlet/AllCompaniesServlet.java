package com.example.my_first_java_servlet;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AllCompaniesServlet", value = "/companies")
public class AllCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {

        Database db = new Database();
        List<Company> companies = db.getAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>Companies</title>");
        out.println("</head>");
        out.println("<body>");

        if(companies.size() == 0) {
            out.println("<p>No registered companies so far </p>");
        } else {
            out.println("<h1>Companies</h1>");
            out.println("<ul>");

            for (Company company : companies) {
                out.println("<li>" + company.getNome() + "</li>");
            }

            out.println("</ul>");
        }


        out.println("</body>");
        out.println("</html>");

    }
}

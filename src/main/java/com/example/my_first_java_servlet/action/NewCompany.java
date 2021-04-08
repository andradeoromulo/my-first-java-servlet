package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Company;
import com.example.my_first_java_servlet.model.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String companyName = request.getParameter("name");
        String companyCreatedAtInput = request.getParameter("date");

        Date companyCreatedAt = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            companyCreatedAt = sdf.parse(companyCreatedAtInput);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company newCompany = new Company(companyName, companyCreatedAt);

        Database db = new Database();
        db.create(newCompany);

        request.setAttribute("companyName", newCompany.getName());

        // We're not going to dispatch request to newCompanyResponse.jsp anymore
        // But implementing a client-side redirect to allCompaniesServlet

        //RequestDispatcher rd =  req.getRequestDispatcher("/newCompanyResponse.jsp");
        //rd.forward(req, resp);

        response.sendRedirect("router?action=list-companies");

    }
}

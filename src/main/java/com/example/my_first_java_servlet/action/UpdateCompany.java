package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Company;
import com.example.my_first_java_servlet.model.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateCompany implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        int companyId = Integer.parseInt(request.getParameter("id"));
        String companyName = request.getParameter("name");
        String companyCreatedAtInput = request.getParameter("date");

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

        return "redirect:router?action=ListCompanies";

    }

}

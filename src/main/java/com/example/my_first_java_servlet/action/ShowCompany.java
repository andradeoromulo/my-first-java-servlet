package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Company;
import com.example.my_first_java_servlet.model.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int companyId = Integer.parseInt(request.getParameter("id"));

        Database db = new Database();
        Company company = db.findOne(companyId);

        request.setAttribute("company", company);

        RequestDispatcher rd = request.getRequestDispatcher("/editCompanyForm.jsp");
        rd.forward(request, response);

    }

}

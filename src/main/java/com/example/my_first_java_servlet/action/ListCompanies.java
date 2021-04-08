package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Company;
import com.example.my_first_java_servlet.model.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCompanies {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = new Database();
        List<Company> companies = db.findAll();

        request.setAttribute("companies", companies);

        RequestDispatcher rd = request.getRequestDispatcher("/allCompaniesResponse.jsp");
        rd.forward(request, response);
    }

}

package com.example.my_first_java_servlet.servlet;

import com.example.my_first_java_servlet.model.Company;
import com.example.my_first_java_servlet.model.Database;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CompanyServlet", value = "/companies")
public class CompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Database db = new Database();
        List<Company> companies = db.findAll();

        String acceptedFormat = request.getHeader("Accept");

        if(acceptedFormat.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("company", Company.class);
            String companiesXML = xStream.toXML(companies);

            response.setContentType("application/xml");
            response.getWriter().print(companiesXML);
        } else if(acceptedFormat.contains("json")) {
            Gson gson = new Gson();
            String companiesJSON = gson.toJson(companies);

            response.setContentType("application/json");
            response.getWriter().print(companiesJSON);
        } else {
            response.setStatus(406);
        }


    }

}

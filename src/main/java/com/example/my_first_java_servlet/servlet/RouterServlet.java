package com.example.my_first_java_servlet.servlet;

import com.example.my_first_java_servlet.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RouterServlet", value = "/router")
public class RouterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action) {
            case "new-company":

                NewCompany newCompany = new NewCompany();
                newCompany.run(req, resp);

                break;
            case "list-companies":

                ListCompanies listCompanies = new ListCompanies();
                listCompanies.run(req, resp);

                break;
            case "show-company":

                ShowCompany showCompany = new ShowCompany();
                showCompany.run(req, resp);

                break;
            case "update-company":

                UpdateCompany updateCompany = new UpdateCompany();
                updateCompany.run(req, resp);

                break;
            case "remove-company":

                RemoveCompany removeCompany = new RemoveCompany();
                removeCompany.run(req, resp);

                break;
        }
    }
}

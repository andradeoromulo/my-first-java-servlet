package com.example.my_first_java_servlet.servlet;

import com.example.my_first_java_servlet.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "RouterServlet", value = "/router")
public class RouterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String className = "com.example.my_first_java_servlet.action." + action;
        String target = null;

        try {
            Class actionClass = Class.forName(className);
            Action actionObject = (Action) actionClass.newInstance();
            target = actionObject.run(req, resp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException();
        }

        String[] targetProps = target.split(":");

        if(targetProps[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + targetProps[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(targetProps[1]);
        }

        /*
         Mapping all requests manually
        switch (action) {
            case "create-company":

                CreateCompany createCompany = new CreateCompany();
                target = createCompany.run(req, resp);

                break;
            case "new-company":

                NewCompany newCompany = new NewCompany();
                target = newCompany.run(req, resp);

                break;
            case "list-companies":

                ListCompanies listCompanies = new ListCompanies();
                target = listCompanies.run(req, resp);

                break;
            case "show-company":

                ShowCompany showCompany = new ShowCompany();
                target = showCompany.run(req, resp);

                break;
            case "update-company":

                UpdateCompany updateCompany = new UpdateCompany();
                target = updateCompany.run(req, resp);

                break;
            case "remove-company":

                RemoveCompany removeCompany = new RemoveCompany();
                target = removeCompany.run(req, resp);

                break;
        }
         */

    }
}

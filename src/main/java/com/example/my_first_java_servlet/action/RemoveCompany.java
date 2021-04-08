package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int companyId = Integer.parseInt(request.getParameter("id"));

        Database db = new Database();
        db.removeById(companyId);

        response.sendRedirect("router?action=list-companies");

    }

}

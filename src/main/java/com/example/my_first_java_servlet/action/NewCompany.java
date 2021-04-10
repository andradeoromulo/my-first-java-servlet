package com.example.my_first_java_servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCompany implements Action {

    public String run(HttpServletRequest request, HttpServletResponse response) {

        return "forward:newCompanyForm.jsp";

    }

}

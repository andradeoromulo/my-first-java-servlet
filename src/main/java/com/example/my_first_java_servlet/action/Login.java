package com.example.my_first_java_servlet.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Action{

    @Override
    public String run(HttpServletRequest request, HttpServletResponse response) {

        return "forward:loginForm.jsp";

    }
}

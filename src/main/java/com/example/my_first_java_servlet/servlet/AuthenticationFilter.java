package com.example.my_first_java_servlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/router")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpSession session = servletRequest.getSession();
        boolean userIsNotAuthenticated = (session.getAttribute("user") == null);

        String action = request.getParameter("action");
        boolean actionIsProtected = !(action.equals("Login") || action.equals("Authenticate"));

        if(userIsNotAuthenticated && actionIsProtected) {
            servletResponse.sendRedirect("router?action=Login");
            return;
        }

        chain.doFilter(request, response);

    }

}

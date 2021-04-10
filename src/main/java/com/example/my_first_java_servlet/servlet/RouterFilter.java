package com.example.my_first_java_servlet.servlet;

import com.example.my_first_java_servlet.action.Action;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RouterFilter")
public class RouterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        String action = servletRequest.getParameter("action");
        String className = "com.example.my_first_java_servlet.action." + action;
        String target = null;

        try {
            Class actionClass = Class.forName(className);
            Action actionObject = (Action) actionClass.newInstance();
            target = actionObject.run(servletRequest, servletResponse);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException();
        }

        String[] targetProps = target.split(":");

        if(targetProps[0].equals("forward")) {
            RequestDispatcher rd = servletRequest.getRequestDispatcher("WEB-INF/view/" + targetProps[1]);
            rd.forward(servletRequest, servletResponse);
        } else {
            servletResponse.sendRedirect(targetProps[1]);
        }

    }

}

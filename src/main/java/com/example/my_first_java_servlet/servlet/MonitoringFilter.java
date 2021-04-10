package com.example.my_first_java_servlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "MonitoringFilter", urlPatterns = "/router")
public class MonitoringFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String action = request.getParameter("action");
        long execStart = System.currentTimeMillis();

        chain.doFilter(request, response);

        long execEnd = System.currentTimeMillis();

        System.out.println((execEnd - execStart) + "ms to run action: " + action);

    }
}

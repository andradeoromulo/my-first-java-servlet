package com.example.my_first_java_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>My first Java Servlet!</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>This is a simple java servlet.</h1>");

        out.println("</body>");
        out.println("</html>");

        System.out.println("My servlet received a requisition");

    }
}
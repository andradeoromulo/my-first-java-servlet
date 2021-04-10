package com.example.my_first_java_servlet.action;

import com.example.my_first_java_servlet.model.Database;
import com.example.my_first_java_servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authenticate implements Action {
    @Override
    public String run(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Database db = new Database();
        User user = db.findOneUser(login, password);

        if(user != null) {
            System.out.println("Authentication suceed");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:router?action=ListCompanies";
        } else {
            System.out.println("Authentication failed");
            return "redirect:router?action=Login";
        }

    }
}

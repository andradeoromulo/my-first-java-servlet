package com.example.my_first_java_servlet.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    public String run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}

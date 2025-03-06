package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminServlet extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.doGet(request, response);
    }

    // edit
    // add recruiter
    // delete recruiter
    // edit recruiter
    // list recruiter
    // add employee
    // delete employee
    // edit employee
    // list  employee
    // add offer
    // delete offer
    // edit offer
    // list  offer

}

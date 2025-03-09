package com.app.jdbc.smartrecruit.filters;

import com.app.jdbc.smartrecruit.models.Admin;
import com.app.jdbc.smartrecruit.models.Employee;
import com.app.jdbc.smartrecruit.models.Recruiter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/recruiter/*"})
public class RecruiterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        // check if user and user's typeof
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/auth/login-form");
        } else if (session.getAttribute("user") instanceof Employee) {
            response.sendRedirect("/employee/profile");
        } else if (session.getAttribute("user") instanceof Admin) {
            response.sendRedirect("/admin/dashboard");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

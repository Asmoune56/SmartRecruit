package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.UserDAO;
import com.app.jdbc.smartrecruit.models.Admin;
import com.app.jdbc.smartrecruit.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/auth/*")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/login-form":
                loginForm(req, resp);
                break;

            case "/register-form":
                registerForm(req, resp);
                break;

            case "/login":
                login(req, resp);
                break;

            case "/logout":
                logout(req, resp);
                break;

            case "/register":
                register(req, resp);
                break;
        }
    }

    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
    }

    private void registerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String birthday = req.getParameter("bdate");

        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("username: " + username);
        System.out.println("fname: " + fname);
        System.out.println("lname: " + lname);
        System.out.println("birthday: " + birthday);


        UserDAO userDAO = new UserDAO();
        User user = new Admin();
        user.setName(lname + " " + fname);
        user.setEmail(email);
        user.setPassword(password);
        user.setUpdatedAt(LocalTime.now());
        user.setCreatedAt(LocalDate.now());
        user.setBirthdate(LocalDate.parse(birthday));


        userDAO.saveUser(user);

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(email, password);
            session.setAttribute("user", user);


            if(user instanceof Admin) {
                resp.sendRedirect("/admin/dashboard");
            }

        }catch (Exception e) {
            System.out.println("Password or username is wrong");
            session.setAttribute("message", "Password or username is wrong");
            session.setAttribute("messageType", "danger");
        }

    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/auth/login-form");
    }
}

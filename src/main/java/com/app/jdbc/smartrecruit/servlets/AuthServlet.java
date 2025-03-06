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
import org.hibernate.Session;

import java.io.IOException;
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
            case "/login":
//                login(req, resp);
                System.out.println("hello");
                break;

            case "/logout":
                logout(req, resp);
                break;

            case "/register":
                register(req, resp);
                break;
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        //
        UserDAO userDAO = new UserDAO();
        User user = new Admin();
        user.setPassword(password);
        user.setUserName(email);

        userDAO.saveUser(user);

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.login(username, password);
            session.setAttribute("user", user);

            if(user instanceof Admin) {
                System.out.println("admin");
            }

        }catch (Exception e) {
            System.out.println("Password or username is wrong");
            session.setAttribute("message", "Password or username is wrong");
            session.setAttribute("messageType", "danger");
        }

//        if (user != null) {
//            HttpSession session = req.getSession();
//            session.setAttribute("user", user);
//
//            switch (user) {
//                case user instanceof Admin:
//                    resp.sendRedirect("adminDashboard.jsp");
//                    break;
//                case "recruiter":
//                    resp.sendRedirect("recruiterDashboard.jsp");
//                    break;
//                case "employer":
//                    resp.sendRedirect("employerDashboard.jsp");
//                    break;
//                default:
//                    resp.sendRedirect("login.jsp?error=invalid_role");
//            }
//        } else {
//            resp.sendRedirect("login.jsp?error=invalid_credentials");
//        }

    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/smartrecruit");
    }
}

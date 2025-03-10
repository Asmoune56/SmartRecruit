package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.UserDAO;
import com.app.jdbc.smartrecruit.models.Admin;
import com.app.jdbc.smartrecruit.models.Employee;
import com.app.jdbc.smartrecruit.models.Recruiter;
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

            case "/edit":
                edit(req, resp);
                break;

            case "/delete":
                delete(req, resp);
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
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String birthday = req.getParameter("bdate");
        String company = req.getParameter("companyName");
        String domain = req.getParameter("domain");

        String utype = req.getParameter("utype");
        String redirect = req.getParameter("redirect");



        UserDAO userDAO =  new UserDAO();
        User user = utype.equals("employee") ? new Employee() : new Recruiter();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setPassword(password);
        user.setUpdatedAt(LocalTime.now());
        user.setCreatedAt(LocalDate.now());
        user.setBirthdate(LocalDate.parse(birthday));

        if(user instanceof Recruiter){
            ((Recruiter) user).setCompanyName(company);
        }

        if(user instanceof Employee){
            ((Employee) user).setDomain(domain);
        }



        userDAO.saveUser(user);
        resp.sendRedirect(redirect);

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
                session.setAttribute("utype", "admin");

            }

            if(user instanceof Recruiter) {
                resp.sendRedirect("/recruiter/dashboard");
                session.setAttribute("utype", "recruiter");

            }
            if(user instanceof Employee){
                resp.sendRedirect("/employee/profile");
                session.setAttribute("utype", "employee");

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

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String birthday = req.getParameter("bdate");
        String company = req.getParameter("companyName");
        String redirect = req.getParameter("redirect");

        try {
            UserDAO userDAO =  new UserDAO();
            User user = userDAO.getUser(email, password);
            user.setFirstName(fname);
            user.setLastName(lname);
            user.setEmail(email);
            user.setPassword(password);
            user.setUpdatedAt(LocalTime.now());
            user.setBirthdate(LocalDate.parse(birthday));
            if(user instanceof Recruiter){
                ((Recruiter) user).setCompanyName(company);
            }

            userDAO.updateUser(user);
            resp.sendRedirect(redirect);
        }catch (Exception e){
            System.out.println("Password or username is wrong");
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String redirect = req.getParameter("redirect");
        HttpSession session = req.getSession();
        try {
            UserDAO userDAO = new UserDAO();
            userDAO.deleteUserById(id);
            session.setAttribute("message", "User deleted successfully");
            resp.sendRedirect("/admin/"+redirect);
        }catch (Exception e) {
            System.out.println("Password or username is wrong");
            resp.sendRedirect("/admin/recruiters");

        }
    }
}

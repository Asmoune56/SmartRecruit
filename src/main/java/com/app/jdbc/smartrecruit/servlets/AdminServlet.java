package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.UserDAO;
import com.app.jdbc.smartrecruit.models.Recruiter;
import com.app.jdbc.smartrecruit.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
            switch (action) {
                case "/dashboard":
                    getDashboard(request, response);
                    break;
                case "/recruiters":
                    getAllRecruiters(request, response);
                    break;
                case "/recruiter/add-form":
                    addRecruiterForm(request, response);
                    break;
                case "/recruiter/edit-form":
                    editRecruiterForm(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
    }

    private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(req, resp);
    }
    private void getAllRecruiters(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> recruiters;
        recruiters = userDAO.getAllRecruiters(Recruiter.class);
        req.setAttribute("users", recruiters);
        req.getRequestDispatcher("/WEB-INF/views/admin/list_recruiters.jsp").forward(req, resp);
    }
    private void addRecruiterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("redirect", "/admin/recruiters");
        req.setAttribute("type", "recruiter");
        req.getRequestDispatcher("/WEB-INF/views/admin/recruiter.jsp").forward(req, resp);
    }
    private void editRecruiterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            User user = userDAO.getUserById(id);
            req.setAttribute("user", user);
            req.setAttribute("type", "recruiter");
            req.setAttribute("redirect", "/admin/recruiters");
            req.getRequestDispatcher("/WEB-INF/views/admin/recruiter.jsp").forward(req, resp);
        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
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

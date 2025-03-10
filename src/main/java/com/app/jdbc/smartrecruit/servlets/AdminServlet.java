package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.OfferDao;
import com.app.jdbc.smartrecruit.daos.UserDAO;
import com.app.jdbc.smartrecruit.models.Employee;
import com.app.jdbc.smartrecruit.models.Offer;
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
    OfferDao offerDAO = new OfferDao();
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

                case "/profile":
                    getProfile(request, response);
                    break;

                // Recruiters funcs
                case "/recruiters":
                    getAllRecruiters(request, response);
                    break;
                case "/recruiter/add-form":
                    addRecruiterForm(request, response);
                    break;
                case "/recruiter/edit-form":
                    editRecruiterForm(request, response);
                    break;

                // Employees funcs
                case "/employees":
                    getAllEmployees(request, response);
                    break;
                case "/employee/add-form":
                    addEmployeeForm(request, response);
                    break;
                case "/employee/edit-form":
                    editEmployeeForm(request, response);
                    break;

                // Offers funcs
                case "/offers":
                    getAllOffers(request, response);
                    break;
                case "/offer/add-form":
                    addOfferForm(request, response);
                    break;
                case "/offer/edit-form":
                    editOfferForm(request, response);
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
    }

    private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(req, resp);
    }
    // profile
    private void getProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
    }

    // recruiters funcs
    private void getAllRecruiters(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> recruiters;
        recruiters = userDAO.getUsersByRole(Recruiter.class);
        req.setAttribute("users", recruiters);
        req.setAttribute("type", "recruiter");
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

    // employee funcs
    private void getAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> employees;
        employees = userDAO.getUsersByRole(Employee.class);
        req.setAttribute("users", employees);
        req.setAttribute("type", "employee");
        req.getRequestDispatcher("/WEB-INF/views/admin/list_employees.jsp").forward(req, resp);
    }
    private void addEmployeeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("redirect", "/admin/employees");
        req.setAttribute("type", "employee");
        req.getRequestDispatcher("/WEB-INF/views/admin/employee.jsp").forward(req, resp);
    }
    private void editEmployeeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            User user = userDAO.getUserById(id);
            req.setAttribute("user", user);
            req.setAttribute("type", "employee");
            req.setAttribute("redirect", "/admin/employees");
            req.getRequestDispatcher("/WEB-INF/views/admin/employee.jsp").forward(req, resp);
        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    // offers funcs
    private void getAllOffers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Offer> offers;
        offers = offerDAO.getAllOffers();
        req.setAttribute("offers", offers);
        req.getRequestDispatcher("/WEB-INF/views/offer/list_offers.jsp").forward(req, resp);
    }
    private void addOfferForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("redirect", "/admin/offers");
        req.getRequestDispatcher("/WEB-INF/views/offer/offer.jsp").forward(req, resp);
    }
    private void editOfferForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Offer offer = offerDAO.getOffer(id);
            req.setAttribute("offer", offer);
            req.setAttribute("redirect", "/admin/offers");
            req.getRequestDispatcher("/WEB-INF/views/offer/offer.jsp").forward(req, resp);
        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}

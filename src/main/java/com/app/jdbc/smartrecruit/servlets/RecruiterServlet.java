package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.OfferDao;
import com.app.jdbc.smartrecruit.models.Offer;
import com.app.jdbc.smartrecruit.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/recruiter/*")
public class RecruiterServlet extends HttpServlet {
    OfferDao offerDAO = new OfferDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/dashboard":
                getDashboard(req, resp);
                break;

            case "/profile":
                getProfile(req,resp);
                break;

            // Offers funcs
            case "/offers":
                getAllOffers(req, resp);
                break;
            case "/offer/add-form":
                addOfferForm(req, resp);
                break;
            case "/offer/edit-form":
                editOfferForm(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        try {
            long offersCount = offerDAO.getOffersCountByUserId(user.getUserId());
            System.out.println(offersCount);
            req.setAttribute("offersCount", offersCount);
            req.getRequestDispatcher("/WEB-INF/views/recruiter/dashboard.jsp").forward(req, resp);

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // profile
    private void getProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
    }

    // offers funcs
    private void getAllOffers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Offer> offers;
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        offers = offerDAO.getOffersByUserId(user.getUserId());
        req.setAttribute("offers", offers);
        req.getRequestDispatcher("/WEB-INF/views/offer/list_offers.jsp").forward(req, resp);
    }
    private void addOfferForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("redirect", "/admin/offers");
        req.getRequestDispatcher("/WEB-INF/views/offer/offer.jsp").forward(req, resp);
    }
    private void editOfferForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = (User) req.getSession().getAttribute("user");

        try {
            Offer offer = offerDAO.getOffer(id);
            // check if offer is created by same user
            if(offer.getCreatedBy().getUserId() == user.getUserId()) {
                req.setAttribute("offer", offer);
                req.setAttribute("redirect", "/admin/offers");
                req.getRequestDispatcher("/WEB-INF/views/offer/offer.jsp").forward(req, resp);
            }else {
                resp.sendRedirect("recruiter/offers");
            }

        }catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}

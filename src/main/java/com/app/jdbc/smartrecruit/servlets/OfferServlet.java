package com.app.jdbc.smartrecruit.servlets;

import com.app.jdbc.smartrecruit.daos.OfferDao;
import com.app.jdbc.smartrecruit.daos.UserDAO;
import com.app.jdbc.smartrecruit.models.Offer;
import com.app.jdbc.smartrecruit.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/offer/*")
public class OfferServlet extends HttpServlet {
    OfferDao offerDao = new OfferDao();
    UserDAO userDao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        switch (action) {
            case "/add":
                addOffer(req, resp);
                break;
            case "/edit":
                editOffer(req, resp);
                break;
            case "/delete":
                deleteOffer(req, resp);
                break;
            default:
                System.out.println("Invalid action");

        }
    }

    private void addOffer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("desc");
        String price = req.getParameter("price");
        String category = req.getParameter("category");

        Offer offer = new Offer();
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        offer.setTitle(title);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setCategory(category);
        offer.setCreatedAt(LocalDate.now());
        offer.setUpdatedAt(LocalDateTime.now());

        try {
            offer.setCreatedBy(user);
            offerDao.addOffer(offer);
            resp.sendRedirect("/admin/offers");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void editOffer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("desc");
        String price = req.getParameter("price");
        String category = req.getParameter("category");

        Offer offer = offerDao.getOffer(id);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setCategory(category);
        offer.setUpdatedAt(LocalDateTime.now());

        try {
            offerDao.updateOffer(offer);
            resp.sendRedirect("/admin/offers");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void deleteOffer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int offerId = Integer.parseInt(req.getParameter("id"));
        try {
            offerDao.deleteOffersById(offerId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

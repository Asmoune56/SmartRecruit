package com.app.jdbc.smartrecruit.daos;

import com.app.jdbc.smartrecruit.models.Offer;
import com.app.jdbc.smartrecruit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OfferDao {
    public Offer getOffer(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Offer.class, id);
        }
    }

    public List<Offer> getAllOffers() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Offer", Offer.class).getResultList();
        }
    }

    public void updateOffer(Offer offer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(offer);
            transaction.commit();

        }
    }

    public void addOffer(Offer offer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(offer);
            transaction.commit();
        }
    }

    public void deleteOffer(Offer offer) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(offer);
            transaction.commit();
        }
    }



    public List<Offer> getOffersByUserId(long userId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
           return session.createQuery("from Offer o where o.createdBy.userId = :userId", Offer.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }
    }

    public void deleteOffersById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("delete from Offer o where o.id = :id", Offer.class)
                    .setParameter("id", id)
                    .executeUpdate();
        }
    }

    public long getOffersCount() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select count(o) from Offer o", Long.class).getSingleResult();
        }
    }

    public long getOffersCountByUserId(long userId) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select count(o) from Offer o where o.createdBy.userId = :userId", Long.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        }
    }

}

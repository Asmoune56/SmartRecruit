package com.app.jdbc.smartrecruit.daos;


import com.app.jdbc.smartrecruit.models.User;
import com.app.jdbc.smartrecruit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    public User login(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User WHERE userName = :userName and password = :password", User.class)
                    .setParameter("userName", username)
                    .setParameter("password", password)
                    .uniqueResult();
        }
    }

    public void saveUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    public void updateUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }
    
    public void deleteUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }
}


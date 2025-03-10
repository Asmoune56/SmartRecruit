package com.app.jdbc.smartrecruit.daos;


import com.app.jdbc.smartrecruit.models.Recruiter;
import com.app.jdbc.smartrecruit.models.User;
import com.app.jdbc.smartrecruit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    public User getUser(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User WHERE email = :email and password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
        }
    }

    public User getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
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

    public void deleteUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if(user != null) {
                session.remove(user);
            }else {
                System.out.println("User not found");
            }
            transaction.commit();
        }
    }

    public List<User> getAllUsersByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u where u.firstName like ':name%' OR u.lastName like ':name%'", User.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }

    public List<User> getUsersByRole(Class<? extends User> role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User u WHERE type(u) = :role ", User.class)
                    .setParameter("role", role)
                    .getResultList();

        }
    }

    public long getUserCountByRole(Class<? extends User> role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select count(u) from User u where type(u) = :role", Long.class)
                    .setParameter("role", role)
                    .uniqueResult();
        }
    }
}


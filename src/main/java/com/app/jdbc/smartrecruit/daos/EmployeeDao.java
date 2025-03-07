package com.app.jdbc.smartrecruit.daos;

import com.app.jdbc.smartrecruit.models.Employee;
import com.app.jdbc.smartrecruit.models.User;
import com.app.jdbc.smartrecruit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {
    public User EmployeeDao (String username , String password){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Employee WHERE username = :username and password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
        }

    }
    public void Employee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }
    }

    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        }
    }
}

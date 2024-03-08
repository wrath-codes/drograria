package com.wrathcodes.restaurant.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wrathcodes.restaurant.util.HibernateUtil;

public class GenericDAO<Entity> {
    public void save(Entity entity) {
        // first we need to capture an open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (RuntimeException error) {
            if (transaction != null) {
                transaction.rollback();
                throw error;
            }
        } finally {
            session.close();
        }
    }
}

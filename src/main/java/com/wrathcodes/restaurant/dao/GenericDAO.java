package com.wrathcodes.restaurant.dao;

import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wrathcodes.restaurant.util.HibernateUtil;

public class GenericDAO<Entity> {
    private Class entityClass;

    // constructor creation
    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

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

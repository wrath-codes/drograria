package com.wrathcodes.restaurant.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wrathcodes.restaurant.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericDAO<Entity> {
    private Class<Entity> entityClass;

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
            session.getEntityManagerFactory().createEntityManager().persist(entity);
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

    public List<Entity> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            CriteriaBuilder query = session.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = query.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);
            CriteriaQuery<Entity> all = criteriaQuery.select(root);
            TypedQuery<Entity> allQuery = session.createQuery(all);

            List<Entity> result = allQuery.getResultList();
            return result;
        } catch (RuntimeException error) {
            throw error;
        } finally {
            session.close();
        }
    }

    public Entity search(Long code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            CriteriaBuilder query = session.getCriteriaBuilder();
            CriteriaQuery<Entity> criteriaQuery = query.createQuery(entityClass);
            Root<Entity> root = criteriaQuery.from(entityClass);
            CriteriaQuery<Entity> one = criteriaQuery.select(root).where(query.equal(root.get("id"), code));
            TypedQuery<Entity> oneQuery = session.createQuery(one);

            Entity result = (Entity) oneQuery.getSingleResult();
            return result;
        } catch (RuntimeException error) {
            throw error;
        } finally {
            session.close();
        }
    }

    public void delete(Entity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.remove(entity);
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

    public void update(Entity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.merge(entity);
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

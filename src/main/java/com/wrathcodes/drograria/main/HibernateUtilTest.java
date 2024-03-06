package com.wrathcodes.drograria.main;

import org.hibernate.Session;

import com.wrathcodes.drograria.util.HibernateUtil;

public class HibernateUtilTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}

package com.wrathcodes.util;

import org.hibernate.Session;
import org.junit.Test;

import com.wrathcodes.drograria.util.HibernateUtil;

public class HibernateUtilTest {

    @Test
    public void connect() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        HibernateUtil.getSessionFactory().close();

    }
}

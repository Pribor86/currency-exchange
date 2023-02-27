package com.example.exchange.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DB {
    private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
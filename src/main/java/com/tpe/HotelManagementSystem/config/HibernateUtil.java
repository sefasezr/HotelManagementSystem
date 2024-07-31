package com.tpe.HotelManagementSystem.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //1. adım sessionfactory'i aktiflestirmem gerekiyor
    private static SessionFactory sessionFactory;
    static{
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("session factory olusturulurken bir sorunla karsilasildi!!! "+e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown(){
        sessionFactory.close();
    }


}

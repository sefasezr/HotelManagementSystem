package com.tpe.HotelManagementSystem.config;

import com.tpe.HotelManagementSystem.domain.Guest;
import com.tpe.HotelManagementSystem.domain.Hotel;
import com.tpe.HotelManagementSystem.domain.Reservation;
import com.tpe.HotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    //1. adım sessionfactory'i aktiflestirmem gerekiyor
    private static SessionFactory sessionFactory;
    static{
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Hotel.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Reservation.class)
                    .addAnnotatedClass(Guest.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initialization of session factory is FAILED!!!");
        }
    }
    //getter SF
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //SF kapatalım
    public static void shutDown(){
        getSessionFactory().close();
    }

    //sessionı kapatalım
    public static void closeSession(Session session){
        if(session != null && session.isOpen()){ //session.isOpen() session hala açık mı kontrolüdür
            session.close();
        }
    }


}

package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Room,Guest ve Reservation için service ve repo classlarını oluşturalım:ÖDEV
public class HotelRepository {

    private Session session;

    //1-b:
    public void save(Hotel hotel) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(hotel);//insert into t_hotel values...
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtil.closeSession(session);
        }

    }
}

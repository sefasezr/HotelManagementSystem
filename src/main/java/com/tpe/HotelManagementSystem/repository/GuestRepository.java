package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtils;
import com.tpe.HotelManagementSystem.domain.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestRepository {

    private Session session;

    public void save(Guest guest) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(guest);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }

    }

    public Guest findById(Long id){
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Guest.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Guest> findAll(){
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            List<Guest> guestList =session.createQuery("FROM Guest", Guest.class).getResultList();
            return guestList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;

    }

    public void delete(Guest foundGuest) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(foundGuest);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}

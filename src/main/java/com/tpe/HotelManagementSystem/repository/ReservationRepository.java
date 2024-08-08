package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtils;
import com.tpe.HotelManagementSystem.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepository {

    private Session session;

    public void save(Reservation reservation) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(reservation);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Reservation findById(Long id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Reservation.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Reservation> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Reservation> reservationList = session.createQuery("FROM Reservation").getResultList();
            return reservationList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Reservation foundReservation) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(foundReservation);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}

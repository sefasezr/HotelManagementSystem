package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtils;
import com.tpe.HotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {

    //ÖDEV: save, findById, findAll
    private Session session;

    public void save(Room room) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(room);
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Room findById(Long id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Room.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Room> findAll() {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            List<Room>roomList=session.createQuery("from Room").getResultList();
            return roomList;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}

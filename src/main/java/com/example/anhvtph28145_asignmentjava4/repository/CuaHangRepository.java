package com.example.anhvtph28145_asignmentjava4.repository;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {

    public List<CuaHang> getAll() {
        List<CuaHang> listCuaHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang ", CuaHang.class);
            listCuaHang = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listCuaHang;
    }

    public CuaHang getOne(UUID id) {
        CuaHang ch = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang where id =:id1", CuaHang.class);
            query.setParameter("id1", id);
            ch = (CuaHang) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return ch;
    }

    public boolean remove(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean add(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


}

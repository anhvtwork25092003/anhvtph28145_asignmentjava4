package com.example.anhvtph28145_asignmentjava4.repository;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    public static void main(String[] args) {
        System.out.println(new CuaHangRepository().getOne("22E44B40-633A-4A89-A6F1-1C847D5F0AA9"));
    }

    public List<ChucVu> getAll() {
        List<ChucVu> listCV = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu ", ChucVu.class);
            listCV = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listCV;
    }

    public ChucVu getOne(String id) {
        ChucVu ch = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu where id =:id1", ChucVu.class);
            query.setParameter("id1", id);
            ch = (ChucVu) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ch;
    }

    public boolean remove(ChucVu cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean add(ChucVu cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(ChucVu cuaHang) {
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

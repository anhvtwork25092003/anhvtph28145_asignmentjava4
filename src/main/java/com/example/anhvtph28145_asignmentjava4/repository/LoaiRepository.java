package com.example.anhvtph28145_asignmentjava4.repository;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.entity.Loai;
import com.example.anhvtph28145_asignmentjava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoaiRepository {
    public static void main(String[] args) {
        System.out.println(new LoaiRepository().getAll());
    }
    public List<Loai> getAll() {
        List<Loai> listLoai = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from Loai ", Loai.class);
            listLoai = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listLoai;
    }

    public Loai getOne(UUID id) {
        Loai ch = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from Loai where id =:id1", Loai.class);
            query.setParameter("id1", id);
            ch = (Loai) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return ch;
    }

    public boolean remove(Loai cuaHang) {
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

    public boolean add(Loai cuaHang) {
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

    public boolean update(Loai cuaHang) {
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

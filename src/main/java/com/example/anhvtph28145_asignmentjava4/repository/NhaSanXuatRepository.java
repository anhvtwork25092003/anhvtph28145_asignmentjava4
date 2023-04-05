package com.example.anhvtph28145_asignmentjava4.repository;

import com.example.anhvtph28145_asignmentjava4.entity.Loai;
import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;
import com.example.anhvtph28145_asignmentjava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhaSanXuatRepository {
    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> listLoai = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhaSanXuat ", NhaSanXuat.class);
            listLoai = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listLoai;
    }

    public NhaSanXuat getOne(UUID id) {
        NhaSanXuat ch = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhaSanXuat where id =:id1", NhaSanXuat.class);
            query.setParameter("id1", id);
            ch = (NhaSanXuat) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return ch;
    }

    public boolean remove(NhaSanXuat cuaHang) {
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

    public boolean add(NhaSanXuat cuaHang) {
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

    public boolean update(NhaSanXuat cuaHang) {
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

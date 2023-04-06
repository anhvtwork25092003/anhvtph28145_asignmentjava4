package com.example.anhvtph28145_asignmentjava4.repository;

import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;
import com.example.anhvtph28145_asignmentjava4.entity.SanPhamChiTiet;
import com.example.anhvtph28145_asignmentjava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamChiTietRepository {
    public List<SanPhamChiTiet> getAll() {
        List<SanPhamChiTiet> listLoai = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPhamChiTiet ", SanPhamChiTiet.class);
            listLoai = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listLoai;
    }

    public SanPhamChiTiet getOne(String id) {
        SanPhamChiTiet ch = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPhamChiTiet where id =:id1", SanPhamChiTiet.class);
            query.setParameter("id1", id);
            ch = (SanPhamChiTiet) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return ch;
    }

    public boolean remove(SanPhamChiTiet cuaHang) {
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

    public boolean add(SanPhamChiTiet cuaHang) {
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

    public boolean update(SanPhamChiTiet cuaHang) {
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

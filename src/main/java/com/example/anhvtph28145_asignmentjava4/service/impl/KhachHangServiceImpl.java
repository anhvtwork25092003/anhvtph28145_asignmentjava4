package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.KhachHang;
import com.example.anhvtph28145_asignmentjava4.repository.KhachHangrepository;
import com.example.anhvtph28145_asignmentjava4.service.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    KhachHangrepository khachHangrepository = new KhachHangrepository();

    @Override
    public List<KhachHang> getAll() {
        return this.khachHangrepository.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return this.khachHangrepository.getOne(id);
    }

    @Override
    public String remove(KhachHang ch) {
        if (this.khachHangrepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String add(KhachHang ch) {
        if (this.khachHangrepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(KhachHang ch) {
        if (this.khachHangrepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }
}

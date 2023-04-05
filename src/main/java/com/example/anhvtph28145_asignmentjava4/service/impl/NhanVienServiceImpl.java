package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.NhanVien;
import com.example.anhvtph28145_asignmentjava4.repository.NhanVienrepository;
import com.example.anhvtph28145_asignmentjava4.service.NhanVienService;

import java.util.List;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    NhanVienrepository nhanVienrepository = new NhanVienrepository();

    @Override
    public List<NhanVien> getAll() {
        return this.nhanVienrepository.getAll();
    }

    @Override
    public NhanVien getOne(String id) {
        return this.nhanVienrepository.getOne(id);
    }

    @Override
    public String remove(NhanVien ch) {
        if (nhanVienrepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String add(NhanVien ch) {
        if (nhanVienrepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(NhanVien ch) {
        if (nhanVienrepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }
}

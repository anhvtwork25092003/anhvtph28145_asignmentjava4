package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.SanPhamChiTiet;
import com.example.anhvtph28145_asignmentjava4.repository.SanPhamChiTietRepository;
import com.example.anhvtph28145_asignmentjava4.service.SanPhamChiTietSerVice;

import java.util.List;

public class SanPhamChiTietImpl implements SanPhamChiTietSerVice {
    private SanPhamChiTietRepository sanPhamChiTietRepository = new SanPhamChiTietRepository();

    @Override
    public List<SanPhamChiTiet> getAll() {
        return this.sanPhamChiTietRepository.getAll();
    }

    @Override
    public SanPhamChiTiet getOne(String id) {
        return this.sanPhamChiTietRepository.getOne(id);
    }

    @Override
    public String remove(SanPhamChiTiet ch) {
        if (this.sanPhamChiTietRepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String add(SanPhamChiTiet ch) {
        if (this.sanPhamChiTietRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(SanPhamChiTiet ch) {
        if (this.sanPhamChiTietRepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai";
        }
    }
}

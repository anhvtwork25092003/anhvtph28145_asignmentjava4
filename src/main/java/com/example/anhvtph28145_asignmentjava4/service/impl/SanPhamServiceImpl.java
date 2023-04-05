package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.SanPham;
import com.example.anhvtph28145_asignmentjava4.repository.SanPhamrepository;
import com.example.anhvtph28145_asignmentjava4.service.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    SanPhamrepository sanPhamrepository = new SanPhamrepository();

    @Override
    public List<SanPham> getAll() {
        return this.sanPhamrepository.getAll();
    }

    @Override
    public SanPham getOne(UUID id) {
        return this.sanPhamrepository.getOne(id);
    }

    @Override
    public String remove(SanPham ch) {
        if (this.sanPhamrepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String add(SanPham ch) {
        if (this.sanPhamrepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String update(SanPham ch) {
        if (this.sanPhamrepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }
}

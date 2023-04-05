package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;
import com.example.anhvtph28145_asignmentjava4.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getOne(UUID id);

    String remove(SanPham ch);

    String add(SanPham ch);

    String update(SanPham ch);
}

package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.SanPhamChiTiet;

import java.util.List;

public interface SanPhamChiTietSerVice {
    List<SanPhamChiTiet> getAll();

    SanPhamChiTiet getOne(String id);

    String remove(SanPhamChiTiet ch);

    String add(SanPhamChiTiet ch);

    String update(SanPhamChiTiet ch);
}

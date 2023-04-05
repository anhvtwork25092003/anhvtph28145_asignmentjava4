package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.KhachHang;
import com.example.anhvtph28145_asignmentjava4.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    String remove(KhachHang ch);

    String add(KhachHang ch);

    String update(KhachHang ch);
}

package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.MauSac;
import com.example.anhvtph28145_asignmentjava4.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien getOne(String id);

    String remove(NhanVien ch);

    String add(NhanVien ch);

    String update(NhanVien ch);
}

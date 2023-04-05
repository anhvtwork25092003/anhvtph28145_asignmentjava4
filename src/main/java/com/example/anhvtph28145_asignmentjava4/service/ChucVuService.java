package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(String id);

    String remove(ChucVu ch);

    String add(ChucVu ch);

    String update(ChucVu ch);
}

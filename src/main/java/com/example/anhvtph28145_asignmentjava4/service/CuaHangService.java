package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getOne(UUID id);

    String remove(CuaHang ch);

    String add(CuaHang ch);

    String update(CuaHang ch);
}

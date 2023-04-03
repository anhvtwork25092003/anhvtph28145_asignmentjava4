package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.entity.Loai;

import java.util.List;
import java.util.UUID;

public interface LoaiService {
    List<Loai> getAll();

    Loai getOne(UUID id);

    String remove(Loai ch);

    String add(Loai ch);

    String update(Loai ch);
}

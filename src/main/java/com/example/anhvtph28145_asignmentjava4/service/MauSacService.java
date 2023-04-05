package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.Loai;
import com.example.anhvtph28145_asignmentjava4.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac getOne(UUID id);

    String remove(MauSac ch);

    String add(MauSac ch);

    String update(MauSac ch);
}

package com.example.anhvtph28145_asignmentjava4.service;

import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(UUID id);

    String remove(NhaSanXuat ch);

    String add(NhaSanXuat ch);

    String update(NhaSanXuat ch);
}

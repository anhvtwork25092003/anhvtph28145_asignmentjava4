package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.MauSac;
import com.example.anhvtph28145_asignmentjava4.repository.MauSacRepository;
import com.example.anhvtph28145_asignmentjava4.service.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {
    MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return this.mauSacRepository.getAll();
    }

    @Override
    public MauSac getOne(UUID id) {
        return this.mauSacRepository.getOne(id);
    }

    @Override
    public String remove(MauSac ch) {
        if (this.mauSacRepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String add(MauSac ch) {
        if (this.mauSacRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String update(MauSac ch) {
        if (this.mauSacRepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }
}

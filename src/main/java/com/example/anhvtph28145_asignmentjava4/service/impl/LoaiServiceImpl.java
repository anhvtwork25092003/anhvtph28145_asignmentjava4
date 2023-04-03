package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.Loai;
import com.example.anhvtph28145_asignmentjava4.repository.LoaiRepository;
import com.example.anhvtph28145_asignmentjava4.service.LoaiService;

import java.util.List;
import java.util.UUID;

public class LoaiServiceImpl implements LoaiService {
    LoaiRepository loaiRepository = new LoaiRepository();

    @Override
    public List<Loai> getAll() {
        return loaiRepository.getAll();
    }

    @Override
    public Loai getOne(UUID id) {
        return loaiRepository.getOne(id);
    }

    @Override
    public String remove(Loai ch) {
        if (this.loaiRepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String add(Loai ch) {
        if (this.loaiRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "Thai Bai!";
        }
    }

    @Override
    public String update(Loai ch) {
        if (this.loaiRepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "Thai Bai!";
        }
    }
}

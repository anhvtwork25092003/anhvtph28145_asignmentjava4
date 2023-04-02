package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.repository.ChucVuRepository;
import com.example.anhvtph28145_asignmentjava4.service.ChucVuService;

import java.util.List;

public class ChucvuServiceImpl implements ChucVuService {
    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return this.chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOne(String id) {
        return this.chucVuRepository.getOne(id);
    }

    @Override
    public String remove(ChucVu ch) {
        if (this.chucVuRepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String add(ChucVu ch) {
        if (this.chucVuRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String update(ChucVu ch) {
        if (this.chucVuRepository.update(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }
}

package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.repository.CuaHangRepository;
import com.example.anhvtph28145_asignmentjava4.service.CuaHangService;

import java.util.List;

public class CuaHangServiceImpl implements CuaHangService {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return this.cuaHangRepository.getAll();
    }

    @Override
    public CuaHang getOne(String id) {
        return this.cuaHangRepository.getOne(id);
    }

    @Override
    public String remove(CuaHang ch) {
        if (this.cuaHangRepository.remove(ch)) {
            return "Thanh cong!";
        } else {
            return "that bai";
        }
    }

    @Override
    public String add(CuaHang ch) {
        if (this.cuaHangRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String update(CuaHang ch) {
        if (this.cuaHangRepository.update(ch)
        ) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }
}

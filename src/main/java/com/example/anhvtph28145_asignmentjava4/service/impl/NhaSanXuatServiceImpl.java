package com.example.anhvtph28145_asignmentjava4.service.impl;

import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;
import com.example.anhvtph28145_asignmentjava4.repository.NhaSanXuatRepository;
import com.example.anhvtph28145_asignmentjava4.service.NhaSanXuatService;

import java.util.List;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    NhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return this.nhaSanXuatRepository.getAll();
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return this.nhaSanXuatRepository.getOne(id);
    }

    @Override
    public String remove(NhaSanXuat ch) {
        if (this.nhaSanXuatRepository.remove(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String add(NhaSanXuat ch) {
        if (this.nhaSanXuatRepository.add(ch)) {
            return "Thanh Cong!";
        } else {
            return "That Bai!";
        }
    }

    @Override
    public String update(NhaSanXuat ch) {
        if(this.nhaSanXuatRepository.update(ch)){
            return "Thanh Cong!";
        }else{
            return "That Bai!";
        }
    }
}

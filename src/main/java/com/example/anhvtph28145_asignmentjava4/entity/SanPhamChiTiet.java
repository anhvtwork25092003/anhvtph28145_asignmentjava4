package com.example.anhvtph28145_asignmentjava4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Table(name = "NhanVien")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SanPhamChiTiet {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;
    @ManyToOne()
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat nhaSanXuat;
    @ManyToOne()
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne()
    @JoinColumn(name = "IdDongSP")
    private Loai dongSP;
    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;
    @Column(name = "GiaBan")
    private Double giaBan;

}

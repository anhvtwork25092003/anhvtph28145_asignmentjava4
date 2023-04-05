package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.entity.NhanVien;
import com.example.anhvtph28145_asignmentjava4.service.ChucVuService;
import com.example.anhvtph28145_asignmentjava4.service.CuaHangService;
import com.example.anhvtph28145_asignmentjava4.service.NhanVienService;
import com.example.anhvtph28145_asignmentjava4.service.impl.ChucvuServiceImpl;
import com.example.anhvtph28145_asignmentjava4.service.impl.CuaHangServiceImpl;
import com.example.anhvtph28145_asignmentjava4.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/view-all",
        "/nhan-vien/add",
        "/nhan-vien/update",
        "/nhan-vien/remove",
        "/nhan-vien/detail",
        "/nhan-vien/view-update",
})
public class NhanVienServlet extends HttpServlet {
    NhanVienService nhanVienService = new NhanVienServiceImpl();
    List<NhanVien> listAll = new ArrayList<>();
    private ChucVuService chucVuService = new ChucvuServiceImpl();
    List<ChucVu> listCV = this.chucVuService.getAll();

    private CuaHangService cuaHangService = new CuaHangServiceImpl();
    List<CuaHang> listCH = this.cuaHangService.getAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("/nhan-vien/view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCV", listCV);
        request.setAttribute("danhSachCH", listCH);
        listAll = this.nhanVienService.getAll();
        request.setAttribute("listNV", listAll);
        request.getRequestDispatcher("/nhanvien/quan-ly-nhan-vien.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien ch = this.nhanVienService.getOne(id);
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", nhanVienService.remove(ch));
        response.sendRedirect("/nhan-vien/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinhInput");
        String ngaySinhStr = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String idch = request.getParameter("IdCH");
        System.out.println("idchhhhhhhhhhhhhhhhhh" + idch);
        String idcv = request.getParameter("IdCV");
        System.out.println("9999999999999999" + idcv);
        String trangThai = request.getParameter("trangThai");


        // Kiểm tra giá trị thuộc tính của đối tượng
        if (ma.trim().equals("") || ten.trim().equals("")
                || tenDem.trim().equals("") || ho.trim().equals("")
                || ngaySinhStr.isEmpty() || sdt.trim().equals("")
                || diaChi.trim().equals("") || matKhau.trim().equals("")
                || idch.trim().equals("") || idcv.trim().equals("")
                || trangThai.trim().equals("")) {
            // Nếu tên rỗng hoặc null, hiển thị thông báo lỗi
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoValidate", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/nhan-vien/view-all");
            return;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(ngaySinhStr);
            NhanVien kh = NhanVien.builder()
                    .ma(ma)
                    .ten(ten)
                    .tenDem(tenDem)
                    .ho(ho)
                    .ngaySinh(date)
                    .sdt(sdt)
                    .diaChi(diaChi)
                    .gioiTinh(gioiTinh)
                    .chucVu(this.chucVuService.getOne(idcv))
                    .cuaHang(this.cuaHangService.getOne(idch))
                    .matKhau(matKhau)
                    .trangThai(Integer.valueOf(trangThai))
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoThanhCongOrThatBai", this.nhanVienService.add(kh));
            response.sendRedirect("/nhan-vien/view-all");
        }
    }
}

package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.entity.SanPham;
import com.example.anhvtph28145_asignmentjava4.service.SanPhamService;
import com.example.anhvtph28145_asignmentjava4.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view-all",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/remove",
        "/san-pham/detail",
        "/san-pham/view-update",
})
public class SanPhamServlet extends HttpServlet {
    SanPhamService sanPhamService = new SanPhamServiceImpl();
    List<SanPham> sanPhams = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sanPhams = this.sanPhamService.getAll();
        request.setAttribute("listCH", sanPhams);
        request.getRequestDispatcher("/sanpham/quan-ly-san-pham.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham ch = this.sanPhamService.getOne(UUID.fromString(id));
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/sanpham/view-update.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham cv = this.sanPhamService.getOne(UUID.fromString(id));
        HttpSession session = request.getSession();
        session.setAttribute("thongBaoThanhCongOrThatBai", this.sanPhamService.remove(cv));
        response.sendRedirect("/san-pham/view-all");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham ch = this.sanPhamService.getOne(UUID.fromString(id));
        request.setAttribute("ch", ch);
        hienThi(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idInput").trim();
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            SanPham ch = this.sanPhamService.getOne(UUID.fromString(id));
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoValidateViewUpdate", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/sanpham/view-update.jsp").forward(request, response);
//            hienThi(request, response);
        } else {
            SanPham ch = SanPham.builder()
                    .id(UUID.fromString(id))
                    .ma(ma)
                    .ten(ten)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoThanhCongOrThatBai", this.sanPhamService.update(ch));
            response.sendRedirect("/san-pham/view-all");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoValidate", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/san-pham/view-all");
        } else {
            SanPham ch = SanPham.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoThanhCongOrThatBai", this.sanPhamService.add(ch));
            response.sendRedirect("/san-pham/view-all");
        }
    }
}

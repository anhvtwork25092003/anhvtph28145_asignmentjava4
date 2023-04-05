package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.service.CuaHangService;
import com.example.anhvtph28145_asignmentjava4.service.impl.CuaHangServiceImpl;
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

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/view-all",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/remove",
        "/cua-hang/detail",
        "/cua-hang/view-update",
})
public class CuaHangServlet extends HttpServlet {
    CuaHangService cuaHangService = new CuaHangServiceImpl();
    List<CuaHang> listAll = new ArrayList<>();

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
        listAll = this.cuaHangService.getAll();
        request.setAttribute("listCH", listAll);
        request.getRequestDispatcher("/cuahang/trang-chu-cua-hang.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id la " + id);
        CuaHang ch = this.cuaHangService.getOne(id);
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/cuahang/view-update.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        CuaHang ch = this.cuaHangService.getOne(id);
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", cuaHangService.remove(ch));
        response.sendRedirect("/cua-hang/view-all");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = this.cuaHangService.getOne(id);
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

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("idInput").trim();
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        String diaChi = request.getParameter("diaChiInput").trim();
        String thanhPho = request.getParameter("thanhPhoInput").trim();
        String quocGia = request.getParameter("quocGiaInput").trim();

        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || thanhPho.isEmpty() || quocGia.isEmpty()) {
            CuaHang ch = this.cuaHangService.getOne(id);
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoError", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/cuahang/view-update.jsp").forward(request, response);
        } else {
            CuaHang ch = CuaHang.builder()
                    .id(id)
                    .ma(ma)
                    .ten(ten)
                    .diaChi(diaChi)
                    .thanhPho(thanhPho)
                    .quocGia(quocGia)
                    .build();
            String thongBaoUpdate =
                    this.cuaHangService.update(ch);
            HttpSession session = request.getSession();
            session.setAttribute("thongBao", thongBaoUpdate);
            response.sendRedirect("/cua-hang/view-all");
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        String diaChi = request.getParameter("diaChiInput").trim();
        String thanhPho = request.getParameter("thanhPhoInput").trim();
        String quocGia = request.getParameter("quocGiaInput").trim();
        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || thanhPho.isEmpty() || quocGia.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoError", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/cua-hang/view-all");
//            hienThi(request, response);
        } else {
            CuaHang ch = CuaHang.builder()
                    .ma(ma)
                    .ten(ten)
                    .diaChi(diaChi)
                    .thanhPho(thanhPho)
                    .quocGia(quocGia)
                    .build();
            this.cuaHangService.add(ch);
            response.sendRedirect("/cua-hang/view-all");
        }

    }
}

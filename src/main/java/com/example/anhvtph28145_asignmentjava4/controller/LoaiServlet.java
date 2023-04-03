package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.entity.Loai;
import com.example.anhvtph28145_asignmentjava4.service.LoaiService;
import com.example.anhvtph28145_asignmentjava4.service.impl.LoaiServiceImpl;
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

@WebServlet(name = "LoaiServlet", value = {
        "/loai/view-all",
        "/loai/add",
        "/loai/update",
        "/loai/remove",
        "/loai/detail",
        "/loai/view-update",
})
public class LoaiServlet extends HttpServlet {
    LoaiService loaiService = new LoaiServiceImpl();
    List<Loai> loais = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("/loai/view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loais = this.loaiService.getAll();
        request.setAttribute("listCH", loais);
        request.getRequestDispatcher("/loai/quan-ly-loai.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Loai ch = this.loaiService.getOne(UUID.fromString(id));
        request.setAttribute("ch", ch);
        hienThi(request, response);

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Loai ch = this.loaiService.getOne(UUID.fromString(id));
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", loaiService.remove(ch));
        response.sendRedirect("/loai/view-all");

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Loai ch = this.loaiService.getOne(UUID.fromString(id));
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/loai/view-update-loai.jsp").forward(request, response);
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoError", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/loai/view-all");
//            hienThi(request, response);
        } else {
            Loai ch = Loai.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.loaiService.add(ch);
            response.sendRedirect("/loai/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idInput").trim();
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            Loai ch = this.loaiService.getOne(UUID.fromString(id));
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoError", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/loai/view-update-loai.jsp").forward(request, response);
//            hienThi(request, response);
        } else {
            Loai ch = Loai.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.loaiService.update(ch);
            response.sendRedirect("/loai/view-all");
        }
    }
}

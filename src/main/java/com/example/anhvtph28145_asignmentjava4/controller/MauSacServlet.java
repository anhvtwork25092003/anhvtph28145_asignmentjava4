package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.MauSac;
import com.example.anhvtph28145_asignmentjava4.service.MauSacService;
import com.example.anhvtph28145_asignmentjava4.service.impl.MauSacServiceImpl;
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

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/view-all",
        "/mau-sac/add",
        "/mau-sac/update",
        "/mau-sac/remove",
        "/mau-sac/detail",
        "/mau-sac/view-update",
})
public class MauSacServlet extends HttpServlet {
    MauSacService mauSacService = new MauSacServiceImpl();
    List<MauSac> mauSacList = new ArrayList<>();

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
        mauSacList = this.mauSacService.getAll();
        request.setAttribute("listCH", mauSacList);
        request.getRequestDispatcher("/mausac/quan-ly-mau-sac.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ch = this.mauSacService.getOne(UUID.fromString(id));
        request.setAttribute("ch", ch);
        hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac ch = this.mauSacService.getOne(UUID.fromString(id));
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", mauSacService.remove(ch));
        response.sendRedirect("/mau-sac/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id la " + id);
        MauSac ch = this.mauSacService.getOne(UUID.fromString(id));
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/mausac/view-update-mau-sac.jsp").forward(request, response);
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
            response.sendRedirect("/mau-sac/view-all");
//            hienThi(request, response);
        } else {
            MauSac ch = MauSac.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.mauSacService.add(ch);
            response.sendRedirect("/mau-sac/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idInput").trim();
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            MauSac ch = this.mauSacService.getOne(UUID.fromString(id));
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoError", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/mausac/view-update-mau-sac.jsp").forward(request, response);
//            hienThi(request, response);
        } else {
            MauSac ch = MauSac.builder()
                    .id(UUID.fromString(id))
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.mauSacService.update(ch);
            response.sendRedirect("/mau-sac/view-all");
        }
    }
}


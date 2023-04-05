package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.ChucVu;
import com.example.anhvtph28145_asignmentjava4.entity.CuaHang;
import com.example.anhvtph28145_asignmentjava4.service.ChucVuService;
import com.example.anhvtph28145_asignmentjava4.service.impl.ChucvuServiceImpl;
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

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/view-all",
        "/chuc-vu/add",
        "/chuc-vu/update",
        "/chuc-vu/remove",
        "/chuc-vu/detail",
        "/chuc-vu/view-update",
})
public class ChucVuServlet extends HttpServlet {
    ChucVuService chucVuService = new ChucvuServiceImpl();
    List<ChucVu> chucVuList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        }  else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        }else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        chucVuList = this.chucVuService.getAll();
        request.setAttribute("listCV", chucVuList);
        request.getRequestDispatcher("/chucv/quan-ly-chuc-vu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu ch = this.chucVuService.getOne(id);
        request.setAttribute("ch", ch);
        hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu cv = this.chucVuService.getOne(id);
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", this.chucVuService.remove(cv));
        response.sendRedirect("/chuc-vu/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu ch = this.chucVuService.getOne(id);
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/chucv/view-update-chuc-vu.jsp").forward(request, response);
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
        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            ChucVu ch = this.chucVuService.getOne(id);
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoError", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/chucv/view-update-chuc-vu.jsp").forward(request, response);
//            hienThi(request, response);
        } else {
            ChucVu ch = ChucVu.builder()
                    .id(id)
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.chucVuService.update(ch);
            response.sendRedirect("/chuc-vu/view-all");
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();

        if (ma.isEmpty() || ten.isEmpty()) {
//            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoError", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/chuc-vu/view-all");
//            hienThi(request, response);
        } else {
            ChucVu ch = ChucVu.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            this.chucVuService.add(ch);
            response.sendRedirect("/chuc-vu/view-all");
        }

    }
}

package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.NhaSanXuat;
import com.example.anhvtph28145_asignmentjava4.service.NhaSanXuatService;
import com.example.anhvtph28145_asignmentjava4.service.impl.NhaSanXuatServiceImpl;
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

@WebServlet(name = "NhaSanXuatServlet", value = {
        "/nha-san-xuat/view-all",
        "/nha-san-xuat/add",
        "/nha-san-xuat/update",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/view-update",
})
public class NhaSanXuatServlet extends HttpServlet {
    NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();
    List<NhaSanXuat> nhaSanXuats = new ArrayList<>();

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
        nhaSanXuats = this.nhaSanXuatService.getAll();
        request.setAttribute("listCH", nhaSanXuats);
        request.getRequestDispatcher("/nhasanxuat/trang-chu-nha-san-xuat.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhaSanXuat ch = this.nhaSanXuatService.getOne(UUID.fromString(id));
        HttpSession session = request.getSession();
        session.setAttribute("thongBao", nhaSanXuatService.remove(ch));
        response.sendRedirect("/nha-san-xuat/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat ch = this.nhaSanXuatService.getOne(UUID.fromString(id));
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/nhasanxuat/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat ch = this.nhaSanXuatService.getOne(UUID.fromString(id));
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
        if (ma.isEmpty() || ten.isEmpty()) {
//             validate trống, thực hiện gửi thông báo về trang view-update với url hiện tại, lấy lại đối tượng nsx để hieernt hị
            NhaSanXuat ch = this.nhaSanXuatService.getOne(UUID.fromString(id));
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoAdd", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/nhasanxuat/view-update.jsp").forward(request, response);
        } else {
            NhaSanXuat ch = NhaSanXuat.builder()
                    .id(UUID.fromString(id))
                    .ma(ma)
                    .ten(ten)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBao", this.nhaSanXuatService.update(ch));
            response.sendRedirect("/nha-san-xuat/view-all");
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maInput").trim();
        String ten = request.getParameter("tenInput").trim();
        if (ma.isEmpty() || ten.isEmpty()) {
// bắt lỗi validate khi thêm, dùng sesion trả về thông báo ở trang chủ
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoError", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/nha-san-xuat/view-all");
        } else {
            NhaSanXuat ch = NhaSanXuat.builder()
                    .ma(ma)
                    .ten(ten)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBao", this.nhaSanXuatService.add(ch));
            response.sendRedirect("/nha-san-xuat/view-all");
        }
    }


}

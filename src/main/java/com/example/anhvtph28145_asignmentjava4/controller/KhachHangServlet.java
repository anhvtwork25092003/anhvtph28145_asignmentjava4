package com.example.anhvtph28145_asignmentjava4.controller;

import com.example.anhvtph28145_asignmentjava4.entity.KhachHang;
import com.example.anhvtph28145_asignmentjava4.service.KhachHangService;
import com.example.anhvtph28145_asignmentjava4.service.impl.KhachHangServiceImpl;
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
import java.util.UUID;

@WebServlet(name = "khachHangServlet", value = {
        "/khach-hang/view-all",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/remove",
        "/khach-hang/detail",
        "/khach-hang/view-update",
})
public class KhachHangServlet extends HttpServlet {
    KhachHangService khachHangService = new KhachHangServiceImpl();
    List<KhachHang> khachHangs = new ArrayList<>();

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
        khachHangs = this.khachHangService.getAll();
        request.setAttribute("listCH", khachHangs);
        request.getRequestDispatcher("/khachhang/quan-ly-khach-hang.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang ch = this.khachHangService.getOne(UUID.fromString(id));
        request.setAttribute("ch", ch);
        hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang cv = this.khachHangService.getOne(UUID.fromString(id));
        HttpSession session = request.getSession();
        session.setAttribute("thongBaoThanhCongOrThatBai", this.khachHangService.remove(cv));
        response.sendRedirect("/khach-hang/view-all");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang ch = this.khachHangService.getOne(UUID.fromString(id));
        System.out.println(ch);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/khachhang/view-update.jsp").forward(request, response);
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinhStr = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        // Kiểm tra giá trị thuộc tính của đối tượng
        if (ma.trim().equals("") || ten.trim().equals("") || tenDem.trim().equals("") || ho.trim().equals("") || ngaySinhStr.isEmpty() || sdt.trim().equals("") || diaChi.trim().equals("") || thanhPho.trim().equals("") || quocGia.trim().equals("")) {
            // Nếu tên rỗng hoặc null, hiển thị thông báo lỗi
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoValidate", "Khong duoc de trong du lieu nhe!");
            response.sendRedirect("/khach-hang/view-all");
            return;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(ngaySinhStr);
            KhachHang kh = KhachHang.builder()
                    .ma(ma)
                    .ten(ten)
                    .tenDem(tenDem)
                    .ho(ho)
                    .ngaySinh(date)
                    .sdt(sdt)
                    .diaChi(diaChi)
                    .thanhPho(thanhPho)
                    .quocGia(quocGia)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoThanhCongOrThatBai", this.khachHangService.add(kh));
            response.sendRedirect("/khach-hang/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinhStr = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        // Kiểm tra giá trị thuộc tính của đối tượng
        if (ma.trim().equals("") || ten.trim().equals("") || tenDem.trim().equals("") || ho.trim().equals("") || ngaySinhStr.isEmpty() || sdt.trim().equals("") || diaChi.trim().equals("") || thanhPho.trim().equals("") || quocGia.trim().equals("")) {
            // Nếu tên rỗng hoặc null, hiển thị thông báo lỗi
            KhachHang ch = this.khachHangService.getOne(UUID.fromString(id));
            request.setAttribute("ch", ch);
            request.setAttribute("thongBaoValidateViewUpdate", "Khong duoc de trong du lieu!");
            request.getRequestDispatcher("/khachhang/view-update.jsp").forward(request, response);
            return;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(ngaySinhStr);
            KhachHang kh = KhachHang.builder()
                    .ma(ma)
                    .ten(ten)
                    .tenDem(tenDem)
                    .ho(ho)
                    .ngaySinh(date)
                    .sdt(sdt)
                    .diaChi(diaChi)
                    .thanhPho(thanhPho)
                    .quocGia(quocGia)
                    .build();
            HttpSession session = request.getSession();
            session.setAttribute("thongBaoThanhCongOrThatBai", this.khachHangService.update(kh));
            response.sendRedirect("/khach-hang/view-all");
        }
    }
}

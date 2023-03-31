package com.example.anhvtph28145_asignmentjava4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/view-all",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/remove",
        "/cua-hang/detail",
        "/cua-hang/view-update",
})
public class CuaHangServlet extends HttpServlet {
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
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) {

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

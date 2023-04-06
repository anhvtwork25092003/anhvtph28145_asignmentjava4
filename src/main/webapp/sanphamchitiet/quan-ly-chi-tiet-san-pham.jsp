<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/6/2023
  Time: 7:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan Ly chi tiet san pham</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <%--thong bao ad update thanh cong--%>
    <% if (request.getSession().getAttribute("thongBaoThanhCongOrThatBai") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getSession().getAttribute("thongBaoThanhCongOrThatBai") %>
    </div>
    <% request.getSession().removeAttribute("thongBaoThanhCongOrThatBai"); %>
    <% } %>
    <%--    form add&detail--%>
    <form method="POST"
          action="/chi-tiet-san-pham/add">
        <h1>Chi Tiet San Pham</h1>
        <div class="row">
            <div class="col-md-12">
                <label for="inInput">ID</label>
                <input type="text" name="giaBan" class="form-control" id="inInput" required/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>San Pham</label>
                <select name="idSP" class="form-control">
                    <c:forEach items="${ danhSachSP }" var="sp">
                        <option value="${sp.id}" ${ctsp.sanPham.id == sp.id ? "selected" : ""}>${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Nha San Xuat</label>
                <select name="idNsx" class="form-control">
                    <c:forEach items="${ danhSachNSX }" var="nsx">
                        <option value="${nsx.id}" ${ctsp.nhaSanXuat.id == nsx.id ? "selected" : ""}>${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mau Sac</label>
                <select name="idMs" class="form-control">
                    <c:forEach items="${ danhSachMS }" var="ms">
                        <option value="${ms.id}"${ctsp.mauSac.id == ms.id ? "selected" : ""} >${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Id Dòng Sản Phẩm</label>
                <%--                        <input type="text" name="idDSP" class="form-control" required/>--%>
                <select name="idDSP" class="form-control">
                    <c:forEach items="${ danhSachDSP }" var="dsp">
                        <option value="${dsp.id}" ${ctsp.dongSP.id == nsx.id ? "selected" : ""}>${dsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm BH</label>
                <input type="text" name="namBH" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Mô tả</label>
                <textarea type="text" name="moTa" class="form-control" required></textarea>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="text" name="soLuongTon" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="text" name="giaNhap" class="form-control" required/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <center><label>Giá Bán</label></center>
                <input type="text" name="giaBan" class="form-control" required/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" onclick="return confirm('Xax Nhan Them?')">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
    <%--    end form add&detail--%>
    <%--        Thong bao validate--%>
    <div class="thongBao">
        <% if (request.getSession().getAttribute("thongBaoValidate") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= request.getSession().getAttribute("thongBaoValidate") %>
        </div>
        <% request.getSession().removeAttribute("thongBaoValidate"); %>
        <% } %>
    </div>
    <%--    table--%>
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>San pham</th>
            <th>Nha San Xuat</th>
            <th> Màu Sắc</th>
            <th>Dong san pham</th>
            <th>Năm Bao Hanh</th>
            <th>Mô tả</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhSachCTSP }" var="ctsp">
            <tr>

                <td>${ ctsp.id }</td>
                <td>${ ctsp.sanPham.ten }</td>
                <td>${ ctsp.nhaSanXuat.ten }</td>
                <td>${ ctsp.mauSac.ten }</td>
                <td>${ ctsp.dongSanPham.ten }</td>
                <td>${ ctsp.namBH }</td>
                <td>${ ctsp.moTa }</td>
                <td>${ ctsp.soLuongTon }</td>
                <td>${ ctsp.giaNhap }</td>
                <td>${ ctsp.giaBan }</td>
                <td>
                    <a class="btn btn-primary"
                       href="/ASM_war_exploded/chi-tiet-sp/edit?namBH=${ ctsp.namBH }">
                        Cập nhật
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger"
                       href="/ASM_war_exploded/chi-tiet-sp/delete?namBH=${ ctsp.namBH }">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--    end table--%>
</div>
</body>
</html>

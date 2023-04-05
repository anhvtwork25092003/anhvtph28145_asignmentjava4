<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/4/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <h2>San pham</h2>
    <%--    form input cua hang--%>

    <div class="form">
        <form action="/khach-hang/add" method="post">
            <%--            id--%>
            <div class="mb-3 mt-3">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Id sẽ tự tăng" readonly name="id"
                       value="${ch.id}">
            </div>
            <%--    ma--%>
            <div class="mb-3">
                <label for="ma">Ma:</label>
                <input type="text" class="form-control" id="ma" placeholder="" name="ma" value="${ch.ma}">
            </div>
            <%--    ten--%>
            <div class="mb-3">
                <label for="ten">ten:</label>
                <input type="text" class="form-control" id="ten" placeholder="" name="ten" value="${ch.ten}">
            </div>
            <%--    ten dem--%>
            <div class="mb-3">
                <label for="tenDem">ten dem:</label>
                <input type="text" class="form-control" id="tenDem" placeholder="" name="tenDem" value="${ch.tenDem}">
            </div>
            <%--    ho--%>
            <div class="mb-3">
                <label for="ho">Ho:</label>
                <input type="text" class="form-control" id="ho" placeholder="" name="ho" value="${ch.ho}">
            </div>
            <%--    ngay sinh--%>
            <div class="mb-3">
                <label for="ngaySinh">Ngay Sinh:</label>
                <input type="date" class="form-control" id="ngaySinh" placeholder="" name="ngaySinh"
                       value="${ch.ngaySinh}">
            </div>
            <%--    sdt--%>
            <div class="mb-3">
                <label for="sdt">SDT:</label>
                <input type="text" class="form-control" id="sdt" placeholder="" name="sdt" value="${ch.sdt}">
            </div>
            <%--    dia chi--%>
            <div class="mb-3">
                <label for="place">Dia chi:</label>
                <input type="text" class="form-control" id="place" placeholder="" name="diaChi" value="${ch.diaChi}">
            </div>
            <%--    thanh pho--%>
            <div class="mb-3">
                <label for="city">thanh Pho:</label>
                <input type="text" class="form-control" id="city" placeholder="" name="thanhPho" value="${ch.thanhPho}">
            </div>
            <%--    quoc gia--%>
            <div class="mb-3">
                <label for="quocGia">quoc gia:</label>
                <input type="text" class="form-control" id="quocGia" placeholder="" name="quocGia"
                       value="${ch.quocGia}">
            </div>
            <%--    mat khau--%>
            <div class="mb-3">
                <label for="pass">Mat Khau:</label>
                <input type="text" class="form-control" id="pass" placeholder="" name="matKhau" value="${ch.matKhau}">
            </div>
            <button type="submit" class="btn btn-success" onclick="return confirm('Xán nhận thêm cửa hàng?')">ADD
            </button>
        </form>
    </div>
    <div class="thongBao">
        <% if (request.getSession().getAttribute("thongBaoValidate") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= request.getSession().getAttribute("thongBaoValidate") %>
        </div>
        <% request.getSession().removeAttribute("thongBaoValidate"); %>
        <% } %>
    </div>
    <div class="tbCuaHang">
        <table class="table table-border">
            <tr>
                <th>id</th>
                <th>Ma so</th>
                <th>Tên</th>
                <th>Tên đệm</th>
                <th>Họ</th>
                <th>ngay sinh</th>
                <th>sdt</th>
                <th>dia chi</th>
                <th>thanh pho</th>
                <th>quoc gia</th>
                <th>mat khau</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCH}" var="sv" varStatus="i">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ma}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tenDem}</td>
                    <td>${sv.ho}</td>
                    <td>${sv.ngaySinh}</td>
                    <td>${sv.sdt}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.thanhPho}</td>
                    <td>${sv.quocGia}</td>
                    <td>${sv.matKhau}</td>
                    <td>
                        <a href="/khach-hang/detail?id=${sv.id}" class="btn btn-primary " role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/khach-hang/view-update?id=${sv.id}" class="btn btn-success " role="button"
                           aria-disabled="true">Update</a>
                        <a href="/khach-hang/remove?id=${sv.id}" class="btn btn-danger "
                           onclick="return confirm('Ban muon xoa dong nay!')" role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--    end table của hàng--%>
</div>
</body>
</html>

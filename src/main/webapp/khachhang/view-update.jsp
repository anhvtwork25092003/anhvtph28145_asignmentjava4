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
<div class="form">
    <form action="/khach-hang/update" method="post">
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
        <button type="submit" class="btn btn-success" onclick="return confirm('Xán nhận thêm cửa hàng?')">Update
        </button>
    </form>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/31/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <%--    bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<% if (request.getSession().getAttribute("thongBao") != null) { %>
<div class="alert alert-danger" role="alert">
    <%= request.getSession().getAttribute("thongBao") %>
</div>
<% request.getSession().removeAttribute("thongBao"); %>
<% } %>
<div class="container mt-3">
    <h2>Cửa Hàng</h2>
    <%--    form input cua hang--%>
    <div class="formCuaHang">
        <form action="/cua-hang/add" method="post">
            <%--            id--%>
            <div class="mb-3 mt-3">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" placeholder="Id sẽ tự tăng" readonly name="idInput"
                       value="${ch.id}">
            </div>
            <%--    ma--%>
            <div class="mb-3">
                <label for="ma">Ma:</label>
                <input type="text" class="form-control" id="ma" placeholder="" name="maInput" value="${ch.ma}">
            </div>
            <%--    ten--%>
            <div class="mb-3">
                <label for="ten">ten:</label>
                <input type="text" class="form-control" id="ten" placeholder="" name="tenInput" value="${ch.ten}">
            </div>
            <%--    dia chi--%>
            <div class="mb-3">
                <label for="diaChi">Dia chi:</label>
                <input type="text" class="form-control" id="diaChi" placeholder="" name="diaChiInput"
                       value="${ch.diaChi}">
            </div>
            <%--    thanh pho--%>
            <div class="mb-3">
                <label for="tp">Thanh pho:</label>
                <input type="text" class="form-control" id="tp" placeholder="" name="thanhPhoInput"
                       value="${ch.thanhPho}">
            </div>
            <%--    quoc gia--%>
            <div class="mb-3">
                <label for="qg">Quoc Gia:</label>
                <input type="text" class="form-control" id="qg" placeholder="" name="quocGiaInput"
                       value="${ch.quocGia}">
            </div>
            <button type="submit" class="btn btn-success" onclick="return confirm('Xán nhận thêm cửa hàng?')">ADD
            </button>
            <div class="text-danger">${thongBaoAdd}</div>
        </form>
    </div>
    <%--    tbale của hàng--%>
    <div class="tbCuaHang">
        <table class="table table-border">
            <tr>
                <th>id</th>
                <th>Ma so</th>
                <th>Tên</th>
                <th>Dia chi</th>
                <th>Thanh Pho</th>
                <th>Quoc Gia</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCH}" var="sv" varStatus="i">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ma}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.thanhPho}</td>
                    <td>${sv.quocGia}</td>
                    <td>
                        <a href="/cua-hang/detail?id=${sv.id}" class="btn btn-primary " role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/cua-hang/view-update?id=${sv.id}" class="btn btn-success " role="button"
                           aria-disabled="true">Update</a>
                        <a href="/cua-hang/remove?id=${sv.id}" class="btn btn-danger "
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

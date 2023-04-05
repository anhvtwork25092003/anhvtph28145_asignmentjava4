<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/4/2023
  Time: 4:31 PM
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

    <div class="formCuaHang">
        <form action="/san-pham/add" method="post">
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
    </div>
    <button type="submit" class="btn btn-success" onclick="return confirm('Xán nhận thêm cửa hàng?')">ADD
    </button>
    </form>
    <% if (request.getSession().getAttribute("thongBaoValidate") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getSession().getAttribute("thongBaoValidate") %>
    </div>
    <% request.getSession().removeAttribute("thongBaoValidate"); %>
    <% } %>
    <br>
    <div class="tbCuaHang">
        <table class="table table-border">
            <tr>
                <th>id</th>
                <th>Ma so</th>
                <th>Tên</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCH}" var="sv" varStatus="i">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ma}</td>
                    <td>${sv.ten}</td>
                    <td>
                        <a href="/san-pham/detail?id=${sv.id}" class="btn btn-primary " role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/san-pham/view-update?id=${sv.id}" class="btn btn-success " role="button"
                           aria-disabled="true">Update</a>
                        <a href="/san-pham/remove?id=${sv.id}" class="btn btn-danger "
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

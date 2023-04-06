<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/5/2023
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quan Ly Nhan Vien</title>
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
        <form action="/nhan-vien/add" method="post">
            <%--            id--%>
            <div class="mb-3 mt-3">
                <label for="idInput">ID:</label>
                <input type="text" class="form-control" id="idInput" placeholder="Id sẽ tự tăng" readonly name="idInput"
                       value="${nv.id}">
            </div>
            <%--    ma--%>
            <div class="mb-3">
                <label for="ma">Ma:</label>
                <input type="text" class="form-control" id="ma" placeholder="" name="ma" value="${nv.ma}">
            </div>
            <%--    ten--%>
            <div class="mb-3">
                <label for="ten">ten:</label>
                <input type="text" class="form-control" id="ten" placeholder="" name="ten" value="${nv.ten}">
            </div>
            <%--    ten dem--%>
            <div class="mb-3">
                <label for="tenDem">ten dem:</label>
                <input type="text" class="form-control" id="tenDem" placeholder="" name="tenDem" value="${nv.tenDem}">
            </div>
            <%--    ho--%>
            <div class="mb-3">
                <label for="ho">Ho:</label>
                <input type="text" class="form-control" id="ho" placeholder="" name="ho" value="${nv.ho}">
            </div>
            <%--gioi tinh--%>
            <div class="mb-3">
                <div class="col-6">
                    <label>Giới tính</label>
                    <input type="radio" name="gioiTinhInput" ${nv.gioiTinh == "Nam"?"checked":""} value="Nam" checked/>Nam
                    <input type="radio" name="gioiTinhInput" ${nv.gioiTinh == "Nu"?"checked":""} value="Nu"/>Nu
                </div>
            </div>
            <%--    ngay sinh--%>
            <div class="mb-3">
                <label for="ngaySinh">Ngay Sinh:</label>
                <input type="date" class="form-control" id="ngaySinh" placeholder="" name="ngaySinh"
                       value="${nv.ngaySinh}">
            </div>
            <%--    sdt--%>
            <div class="mb-3">
                <label for="sdt">SDT:</label>
                <input type="text" class="form-control" id="sdt" placeholder="" name="sdt" value="${nv.sdt}">
            </div>
            <%--    dia chi--%>
            <div class="mb-3">
                <label for="place">Dia chi:</label>
                <input type="text" class="form-control" id="place" placeholder="" name="diaChi" value="${nv.diaChi}">
            </div>
            <%--    mat khau--%>
            <div class="mb-3">
                <label for="pass">Mat Khau:</label>
                <input type="password" class="form-control" id="pass" placeholder="" name="matKhau"
                       value="${nv.matKhau}">
            </div>
            <%--    Cua Hang--%>
            <div class="mb-3">
                <label>Cua Hang</label> </br>
                <select name="IdCH" class="form-control" required>
                    <c:forEach items="${danhSachCH}" var="ch">
                        <option value="${ch.id}" ${nv.cuaHang.id == ch.id ? "selected" : ""}>${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <%--   Chuc vu--%>
            <div class="mb-3">
                <label>Chuc Vu</label> </br>
                <select name="IdCV" class="form-control" required>
                    <c:forEach items="${danhSachCV}" var="cv">
                        <%--                    <option value="${cv.id}">${cv.ten}</option>--%>
                        <option value="${cv.id}" ${nv.chucVu.id == cv.id ? "selected" : ""}>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <%--   Ctrang thai--%>
            <div class="mb-3">
                <div class="col-6">
                    <label>Trang Thai</label>
                    <input type="radio" name="trangThai" ${nv.trangThai == 1?"checked":""} value="1" checked/>Lam
                    <input type="radio" name="trangThai" ${nv.trangThai == 0?"checked":""} value="0"/>Nghi
                </div>
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
                <th>Gioi Tinh</th>
                <th>ngay sinh</th>
                <th>sdt</th>
                <th>dia chi</th>
                <th>Cua Hang</th>
                <th>Chuc vu</th>
                <th>mat khau</th>
                <th>Trang Thai</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listNV}" var="nv" varStatus="i">
                <tr>
                    <td>${nv.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.tenDem}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.cuaHang.ten}</td>
                    <td>${nv.chucVu.ten}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.trangThai}</td>
                    <td>
                        <a href="/nhan-vien/detail?id=${nv.id}" class="btn btn-primary " role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/nhan-vien/view-update?id=${nv.id}" class="btn btn-success " role="button"
                           aria-disabled="true">Update</a>
                        <a href="/nhan-vien/remove?id=${nv.id}" class="btn btn-danger "
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
<script>
    // sử dụng JavaScript để điền giá trị vào ô input date
    var birthday = '${nv.ngaySinh}';
    var formattedDate = new Date(birthday).toISOString().substr(0, 10);
    document.getElementById("ngaySinh").value = formattedDate;
</script>
</body>
</html>

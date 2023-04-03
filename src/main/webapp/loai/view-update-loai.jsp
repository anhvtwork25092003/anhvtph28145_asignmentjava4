<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/3/2023
  Time: 10:17 PM
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
<form action="/loai/update" method="post">
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
    <button type="submit" class="btn btn-success" onclick="return confirm('Xán nhận thêm cửa hàng?')">ADD
    </button>
    <div class="text-danger">${thongBaoAdd}</div>
</form>
</body>
</html>

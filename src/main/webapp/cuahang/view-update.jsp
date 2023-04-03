<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/31/2023
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View update cua hang!</title>
</head>
<body>
<form action="/cua-hang/update" method="post">
    <div> id:<input type="text" name="idInput" readonly value="${ch.id}"></div>
    <div> Ma:<input type="text" name="maInput" value="${ch.ma}">
    </div>
    <div> Ten:<input type="text" name="tenInput" value="${ch.ten}"></div>
    <div> Dia chi:<input type="text" name="diaChiInput" value= "${ch.diaChi}"></div>
    <div> Thanh Pho:<input type="text" name="thanhPhoInput" value="${ch.thanhPho}"></div>
    <div> Quoc Gia:<input type="text" name="quocGiaInput" value="${ch.quocGia}"></div>
    <button type="submit" onclick="return confirm('Ban muon cap nhat ?')">Update</button>
    ${thongBaoError}
</form>
</body>
</html>

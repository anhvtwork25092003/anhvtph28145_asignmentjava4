<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/31/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--form detail & add--%>
<form action="">
    <div> id:<input type="text" name="maInput" readonly value="${mt.id}"></div>
    <div> Ma:<input type="text" name="maInput" value="${mt.ma}"></div>
    <div> Ten:<input type="text" name="tenInput" value="${mt.ten}"></div>
    <div> Dia chi:<input type="text" name="tuoiInput" value= ${mt.diaChi}></div>
    <div> Thanh Pho:<input type="text" name="queInput" value="${mt.thanhPho}"></div>
    <div> Quoc Gia:<input type="text" name="queInput" value="${mt.quocGia}"></div>
</form>
<table>
    <tr>
        <th>id</th>
        <th>Ma so</th>
        <th>Tên</th>
        <th>Dia chi</th>
        <th>Thanh Pho</th>
        <th>Quoc Gia</th>
        <th colspan="2">Action</th>
        <br>
        <div style="color: darkred"> ${alertMes}
        </div>
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
                <a href="/cua-hang/remove?id=${sv.id}" class="btn btn-danger " role="button"
                   aria-disabled="true">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

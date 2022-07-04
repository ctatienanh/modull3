<%--
  Created by IntelliJ IDEA.
  User: TienAnh
  Date: 7/1/2022
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=create" method="post">
    <input placeholder="Nhap ID" name="id">
    <input placeholder="Nhap ten" name="name">
    <input placeholder="Nhap price" name="price">
    <input placeholder="Nhap img" name="img">
    <button type="submit">ADD</button>
</form>
</body>
</html>

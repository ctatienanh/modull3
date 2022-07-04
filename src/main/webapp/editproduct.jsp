<%--
  Created by IntelliJ IDEA.
  User: TienAnh
  Date: 7/1/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="${product.img}">
<form action="/product?action=create&id=${product.id}" method="post">
    <input placeholder="Nhap ten" name="name">
    <input placeholder="Nhap price" name="price">
    <input placeholder="Nhap img" name="img">
    <button type="submit">Edit</button>
</form>
</body>
</html>

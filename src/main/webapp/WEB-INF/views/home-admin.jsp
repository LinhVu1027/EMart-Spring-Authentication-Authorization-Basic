<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello Admin!

<a href="<spring:url value="/admin/product/add-product"/>">Add Product</a>

<table>
    <thead>
    <tr>
        <th>Photo Thumb</th>
        <th>Product Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%" /></td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice}</td>
            <td>
                <a href="<spring:url value="/product/view-product/${product.productId}"/>">
                    See</a>
                <a href="<spring:url value="/admin/product/delete-product/${product.productId}"/>">
                    Delete</a>
                <a href="<spring:url value="/admin/product/edit-product/${product.productId}"/>">
                    Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

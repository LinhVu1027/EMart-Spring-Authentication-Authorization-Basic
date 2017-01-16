<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello eMart!

    <ul class="nav navbar-nav pull-right">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
            <li><a href="<c:url value="/logout"/>">Logout</a></li>
            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                <li><a href="<c:url value="/user"/>">Cart</a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                <li><a href="<c:url value="/admin"/>">Admin</a></li>
            </c:if>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li><a href="<c:url value="/login"/>">Login</a></li>
            <li><a href="<c:url value="/register"/>">Register</a></li>
        </c:if>
    </ul>

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
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

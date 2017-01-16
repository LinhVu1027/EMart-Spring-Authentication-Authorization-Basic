<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
   <c:set var="url" scope="page" value="user" />
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
    <c:set var="url" scope="page" value="admin" />
</c:if>

<form:form action="${pageContext.request.contextPath}/${url}/product/edit-product"
           method="post" commandName="product" enctype="multipart/form-data">

    <form:hidden path="productId" value=""/>
    <form:hidden path="customer.customerId" value="" />

    <div class="form-group">
        <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #ff0000"/>
        <form:input path="productName" id="name" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="category">Category</label>
        <form:input path="productCategory" id="category" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="description">Description</label>
        <form:textarea path="productDescription" id="description" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="price">Price</label> <form:errors path="productPrice" cssStyle="color: #ff0000"/>
        <form:input path="productPrice" id="price" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="condition">Condition</label>
        <form:input path="productCondition" id="condition" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="status">Status</label>
        <form:input path="productStatus" id="status" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="unitInStock">Unit In Stock</label> <form:errors path="unitInStock" cssStyle="color: #ff0000"/>
        <form:input path="unitInStock" id="unitInStock" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <form:input path="productManufacturer" id="manufacturer" class="form-control"/>
    </div>

    <div class="form-group">
        <label class="control-label" for="product-image">Upload Picture</label>
        <form:input path="productImage" id="product-image" type="file" class="form:input-large"/>
    </div>

    <br/><br/>
    <input type="submit" value="Submit" class="btn btn-default"/>
    <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>

</form:form>

</body>
</html>

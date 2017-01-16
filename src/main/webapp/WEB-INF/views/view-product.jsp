<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%; height:300px;"/>
<p><strong>Name: </strong> ${product.productName}</p>
<p><strong>Category: </strong> ${product.productCategory}</p>
<p><strong>Desciption: </strong> ${product.productDescription}</p>
<p><strong>Price: </strong> ${product.productPrice}</p>
<p><strong>Condition: </strong> ${product.productCondition}</p>
<p><strong>Status: </strong> ${product.productStatus}</p>
<p><strong>Unit in Stock: </strong> ${product.unitInStock}</p>
<p><strong>Manufacturer: </strong> ${product.productManufacturer}</p>

</body>
</html>

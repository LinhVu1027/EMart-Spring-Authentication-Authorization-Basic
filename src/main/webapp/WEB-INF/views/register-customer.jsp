<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/register"
           method="post" commandName="customer" >

    <h3>Basic Info</h3>

    <div class="form-group">
        <label for="name">Name</label><form:errors path="customerName" cssStyle="color: #ff0000"/>
        <form:input path="customerName" id="name" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="email">Email</label><span style="color: #ff0000">${emailMsg}</span><form:errors path="customerEmail" cssStyle="color: #ff0000"/>
        <form:input path="customerEmail" id="email" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input path="customerPhone" id="phone" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="username">Username</label><span style="color: #ff0000">${usernameMsg}</span><form:errors path="username" cssStyle="color: #ff0000"/>
        <form:input path="username" id="username" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="password">Password</label><form:errors path="password" cssStyle="color: #ff0000"/>
        <form:password path="password" id="password" class="form-control"/>
    </div>

    <h3>Address Info</h3>

    <div class="form-group">
        <label for="billingStreet">Street Name</label>
        <form:input path="streetName" id="billingStreet" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="billingApartmentNumber">Apartment Number</label>
        <form:input path="apartmentNumber" id="billingApartmentNumber" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="billingCity">City</label>
        <form:input path="city" id="billingCity" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="billingState">State</label>
        <form:input path="state" id="billingState" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="billingCountry">Country</label>
        <form:input path="country" id="billingCountry" class="form-control"/>
    </div>

    <div class="form-group">
        <label for="billingZipCode">Zip Code</label>
        <form:input path="zipCode" id="billingZipCode" class="form-control"/>
    </div>

    <br/><br/>
    <input type="submit" value="Submit" class="btn btn-default"/>
    <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>

</form:form>

</body>
</html>

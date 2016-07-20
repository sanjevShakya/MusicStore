<<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="templates/header.jsp"%>
<div class="container-fluid">
    <div class="container">
        <div class="jumbotron">
            <h1>Product Details</h1>
            <p>Here is the detail info of the product</p>
        </div>
       <div class="container" ng-app="cartApp">
           <div class="row">
               <div class="col-md-5">
                   <img src="<c:url value="/resources/images/${product.productId}.png"/>"alt="image" class="img-responsive img-rounded img-thumbnail" style="width: 100%">
               </div>
               <div class="col-md-5">
                   <h3>Product Name:${product.productName} </h3>
                   <p>Product Description: ${product.productDescription}</p>
                   <p>Manufacturer: ${product.productManufacturer}</p>
                   <p>Category: ${product.productCategory}</p>
                   <p>Condition: ${product.productCondition}</p>
                   <p>Price: ${product.productPrice}</p>
                   <br>
                   <c:set var="role" scope="page" value="${param.role}"/>
                   <c:set var="url" scope="page" value="/productList"/>
                   <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                   </c:if>
                    <p ng-controller="cartCtrl">
                        <a class= "btn btn-primary" href="<c:url value="${url}"/>">Back</a>
                        <a class="btn btn-warning btn-lg" ng-click="addToCart('${product.productId}')">
                            <spam class="glyphicon glyphicon-shopping-cart"></spam>Order Now</a>
                        <a class="btn btn-default" href="<spring:url value="/cart"/>">
                            <span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>
               </div>
           </div>
       </div>
    </div>
</div>
<script src="<c:url value="/resources/js/controller.js"/>"/>
<%@include file="templates/footer.jsp"%>
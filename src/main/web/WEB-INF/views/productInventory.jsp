<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="templates/header.jsp"%>
<div class="container-fluid">
    <div class="container">
        <div class="jumbotron">
            <h1>Product Inventory Page</h1>
            <p id="lead">This is the product inventory page</p>
        </div>
        <table class="table table-bordered table-responsive table-hover">
            <tr class="bg-success">
                <th>PhotoThumb</th>
                <th>Name</th>
                <th>Category</th>
                <th>Description</th>
                <th>Price</th>
                <th>Condition</th>
                <th>Status</th>
                <th>Manufacturer</th>

            </tr>
            <c:forEach var="product" items="${products}">


                <tr>
                    <td><img src="#"alt="image"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productStatus}</td>
                    <td>${product.productManufacturer}</td>
                    <th><a href="<spring:url value="/productList/viewProduct/${product.productId}"/>"> <span class="btn btn-primary glyphicon glyphicon-info-sign"></span> </a></th>
                    <th><a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>"> <span class="btn btn-primary btn-danger glyphicon glyphicon-remove"></span> </a></th>
                </tr>
            </c:forEach>

        </table>
        <a href="<spring:url value="/admin/productInventory/addProduct"/>"class="btn btn-primary glyphicon glyphicon-plus-sign"></a>
</div>

<%@include file="templates/footer.jsp"%>
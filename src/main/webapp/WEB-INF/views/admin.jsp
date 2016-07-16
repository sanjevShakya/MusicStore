<%@include file="templates/header.jsp"%>
<div class="container">
    <div class="jumbotron">
        <h1>Admin Page</h1>
    <p class="lead">This is administrator page</p></div>
    <div class="container">
        <h3><a href="<c:url value="/admin/productInventory"/>">Product Inventory</a> </h3>
        <p>Here you can view, check and modify the product inventory!</p>
    </div>
</div>

<%@include file="templates/footer.jsp"%>

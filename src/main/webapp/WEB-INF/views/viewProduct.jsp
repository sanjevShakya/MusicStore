<<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="templates/header.jsp"%>
<div class="container-fluid">
    <div class="container">
        <div class="jumbotron">
            <h1>Product Details</h1>
            <p>Here is the detail info of the product</p>
        </div>
       <div class="container">
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
               </div>
           </div>
       </div>
    </div>
</div>

<%@include file="templates/footer.jsp"%>
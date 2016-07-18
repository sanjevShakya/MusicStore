<%@include file="templates/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>Selected products in your shopping cart</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div>
                <a class="btn btn-danger pull-left" href="#"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
            </div>
            <table class="table table-responsive table-bordered table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>productName</td>
                    <td>productPrice</td>
                    <td>quantity</td>
                    <td>totalPrice</td>
                    <td>remvoveButton</td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>grandTotal</th>
                    <th></th>
                </tr>

            </table>
            <a href="<c:url value="/productList"/>">Continue Shopping</a>
        </section>
    </div>
</div>
<%@include file="templates/footer.jsp"%>
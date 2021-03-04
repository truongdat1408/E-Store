<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <c:choose>
            <c:when test="${cart == null || empty cart.cartItems}">
                Cart is empty
            </c:when>
            <c:otherwise>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                        <tr class="cart_menu">
                            <td class="image">Item</td>
                            <td class="description"></td>
                            <td class="price">Price</td>
                            <td class="quantity">Quantity</td>
                            <td class="total">Total</td>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cart.cartItems}" var="cartItem">
                            <tr>
                                <td class="cart_product">
                                    <a href="/product/${cartItem.product.id}"><img style="width: 110px; height: 110px"
                                                                                   src="/images/${cartItem.product.image}"
                                                                                   alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href="">${cartItem.product.name}</a></h4>
                                    <p>ID: ${cartItem.product.id}</p>
                                </td>
                                <td class="cart_price">
                                    $${cartItem.product.price}
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href="increseQuantity/${cartItem.product.id}">
                                            + </a>
                                        <input class="cart_quantity_input" type="text" name="quantity"
                                               value="${cartItem.quantity}" autocomplete="off" size="2">
                                        <a class="cart_quantity_down" href="decreseQuantity/${cartItem.product.id}">
                                            - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">$${cartItem.total}</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="/deleteCartItem/${cartItem.product.id}"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</section>
<!--/#cart_items-->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="/css/detailProduct.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->

<section>
    <div class="container">
        <div class="card">
            <div class="container-fliud">
                <c:choose>
                    <c:when test="${product != null}">
                        <div class="wrapper row">
                            <div class="preview col-md-6">

                                <div class="preview-pic tab-content">
                                    <div class="tab-pane active" id="pic-1"><img src="/images/${product.getImage()}"/></div>
                                    <div class="tab-pane" id="pic-2"><img src="/images/${product.getImage()}"/></div>
                                    <div class="tab-pane" id="pic-3"><img src="/images/${product.getImage()}"/></div>
                                    <div class="tab-pane" id="pic-4"><img src="/images/${product.getImage()}"/></div>
                                    <div class="tab-pane" id="pic-5"><img src="/images/${product.getImage()}"/></div>
                                </div>
                                <ul class="preview-thumbnail nav nav-tabs">
                                    <li class="active"><a data-target="#pic-1" data-toggle="tab"><img
                                            src="/images/${product.getImage()}"/></a></li>
                                    <li><a data-target="#pic-2" data-toggle="tab"><img
                                            src="/images/${product.getImage()}"/></a></li>
                                    <li><a data-target="#pic-3" data-toggle="tab"><img
                                            src="/images/${product.getImage()}"/></a></li>
                                    <li><a data-target="#pic-4" data-toggle="tab"><img
                                            src="/images/${product.getImage()}"/></a></li>
                                    <li><a data-target="#pic-5" data-toggle="tab"><img
                                            src="/images/${product.getImage()}"/></a></li>
                                </ul>

                            </div>
                            <div class="details col-md-6">
                                <h3 class="product-title">${product.getName()}</h3>
                                <div class="rating">
                                    <div class="stars">
                                        <span class="fa fa-star checked"></span>
                                        <span class="fa fa-star checked"></span>
                                        <span class="fa fa-star checked"></span>
                                        <span class="fa fa-star"></span>
                                        <span class="fa fa-star"></span>
                                    </div>
                                    <span class="review-no">41 reviews</span>
                                </div>
                                <p class="product-description">Suspendisse quos? Tempus cras iure temporibus? Eu laudantium
                                    cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.</p>
                                <h4 class="price">current price: <span>$${product.getPrice()}</span></h4>
                                <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong>
                                </p>
                                <h5 class="sizes">sizes:
                                    <span class="size" data-toggle="tooltip" title="small">s</span>
                                    <span class="size" data-toggle="tooltip" title="medium">m</span>
                                    <span class="size" data-toggle="tooltip" title="large">l</span>
                                    <span class="size" data-toggle="tooltip" title="xtra large">xl</span>
                                </h5>
                                <h5 class="colors">colors:
                                    <span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
                                    <span class="color green"></span>
                                    <span class="color blue"></span>
                                </h5>
                                <div class="action">
                                    <a class="add-to-cart btn btn-default" href="/addToCart?productId=${product.id}">add to cart</a>
                                    <button class="like btn btn-default" type="button"><span class="fa fa-heart"></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        This product is not existed!!!
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</section>

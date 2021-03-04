<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>

                    <c:forEach items="${products.pageList}" var="product">
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img width="268" height="249" src="/images/${product.image}" alt="image product"/>
                                    <tag:price price="${product.price}"/>
                                    <p>${product.name}</p>
                                    <a href="/addToCart?productId=${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add
                                        to cart</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <tag:price price="${product.price}"/>
                                        <p>
                                        <a style="color: white" href="/product/${product.id}">${product.name}</a>
                                        </p>
                                        <a href="/addToCart?productId=${product.id}" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                </div>
                            </div>
                            <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                    <ul class="col-sm-12 pagination">
                        <li>
                            <a class="page-link" href="/categories/${category_slug}?page=1">First</a>
                        </li>
                        <li>
                            <c:choose>
                                <c:when test="${currentIndex eq 1}">
                                    <a href="/categories/${category_slug}?page=1"
                                       title='Go to previous page'>«</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/categories/${category_slug}?page=${currentIndex - 1}"
                                       title='Go to previous page'>«</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <c:forEach begin="${beginIndex}" end="${endIndex}" varStatus="status">
                            <c:choose>
                                <c:when test="${currentPage eq status.index}">
                                    <li class="active"><a href="/categories/${category_slug}?page=${currentPage}">${status.index}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="/categories/${category_slug}?page=${status.index}">${status.index}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <li>
                        <c:choose>
                            <c:when test="${currentPage eq totalPageCount}">
                                <a href="/categories/${category_slug}?page=${totalPageCount}"
                                   title='Go to next page'>»</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/categories/${category_slug}?page=${currentPage + 1}"
                                   title='Go to next page'>»</a>
                            </c:otherwise>
                        </c:choose>
                        </li>

                        <li class="${currentIndex eq totalPageCount}? 'disabled':''">
                            <a class="page-link" href="/categories/${category_slug}?page=${totalPageCount}">Last</a>
                        </li>
                    </ul>

                </div><!--features_items-->
            </div>
            <div class="col-sm-3">
                <div class="search_box pull-right">
                    <input type="text" placeholder="Search"/>
                </div>
            </div>
        </div>
    </div>
</section>


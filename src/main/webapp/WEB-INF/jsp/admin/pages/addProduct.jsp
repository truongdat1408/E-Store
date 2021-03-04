<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="col-md-9">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-12">
                    <h4>Add product</h4>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form:form action="/admin/add-product" method="post" modelAttribute="addProductForm"
                               enctype="multipart/form-data">
                        <div class="form-group row">
                            <form:label path="name" class="col-2 col-form-label">Name</form:label>
                            <div class="col-10">
                                <form:input path="name" placeholder="Name" class="form-control here"/>
                            </div>
                            <form:errors path="name"/>
                        </div>
                        <div class="form-group row">
                            <form:label path="description" class="col-2 col-form-label">Description</form:label>
                            <div class="col-10">
                                <form:input path="description" placeholder="Description" class="form-control here"/>
                            </div>
                            <form:errors path="description"/>
                        </div>
                        <div class="form-group row">
                            <form:label path="quantity" class="col-2 col-form-label">Quantity</form:label>
                            <div class="col-10">
                                <form:input path="quantity" placeholder="Quantity" class="form-control here"/>
                            </div>
                            <form:errors path="quantity"/>
                        </div>
                        <div class="form-group row">
                            <form:label path="price" class="col-2 col-form-label">Price</form:label>
                            <div class="col-10">
                                <form:input path="price" placeholder="Price" class="form-control here"/>
                            </div>
                            <form:errors path="price"/>
                        </div>

                        <div class="form-group row">
                            <form:label path="categoryId" class="col-2 col-form-label">Category</form:label>
                            <div class="col-10">
                                <form:select path="categoryId">
                                    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                    <%--                                        <form:input path="price" placeholder="Price" class="form-control here"/>--%>
                            </div>
                            <form:errors path="categoryId"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Image<label>
                                <div class="col-10">
                                    <input type="file" name="productImage">
                                </div>
                        </div>

                        <div class="form-group row">
                            <div class="offset-12 col-10">
                                <button name="submit" type="submit" class="btn btn-primary">Add product</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>

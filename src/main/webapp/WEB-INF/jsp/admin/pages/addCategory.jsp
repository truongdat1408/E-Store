<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-md-9">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-12">
                    <h4>Add category</h4>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form:form action="/admin/add-category" method="post" modelAttribute="addCategoryForm">
                        <div class="form-group row">
                            <form:label path="name" class="col-2 col-form-label">Name</form:label>
                            <div class="col-10">
                                <form:input path="name" name="username" placeholder="Name" class="form-control here"/>
                            </div>
                            <form:errors path="name"/>
                        </div>
                        <div class="form-group row">
                            <form:label path="sorting" class="col-2 col-form-label">Order</form:label>
                            <div class="col-10">
                                <form:input path="sorting" placeholder="Order" class="form-control here"/>
                            </div>
                            <form:errors path="sorting"/>
                        </div>
                        <div class="form-group row">
                            <div class="offset-12 col-10">
                                <button name="submit" type="submit" class="btn btn-primary">Add category</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>


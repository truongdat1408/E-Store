<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-9">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-2 border-right">
                    <h4>Categories</h4>
                </div>
                <div class="col-md-6">
                    <a href="/admin/add-category" type="button" class="btn btn-sm btn-primary">Add New</a>
                </div>
            </div>
            <hr>

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover ">
                        <thead class="bg-light ">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Slug</th>
                            <th>Sorting</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td>${category.id}</td>
                                <td><small>${category.name}</small></td>
                                <td><small>${category.slug}</small></td>
                                <td>${category.sorting}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


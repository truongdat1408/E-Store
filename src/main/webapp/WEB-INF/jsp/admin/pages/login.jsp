<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Login</h4>
                            <hr>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <form:form action="/admin/login" method="post" modelAttribute="loginForm">
                                <div class="form-group row">
                                    <form:label path="username" class="col-3 col-form-label">Username</form:label>
                                    <div class="col-9">
                                        <form:input path="username" value="admin" name="username" placeholder="Username" class="form-control here"/>
                                    </div>
                                    <div class="col-sm-3">
                                        <small class="text-danger">
                                            <form:errors path="username"/>
                                        </small>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <form:label path="password" class="col-3 col-form-label">Password</form:label>
                                    <div class="col-9">
                                        <form:password path="password" value="admin" placeholder="Password" class="form-control here"/>
                                    </div>
                                    <div class="col-sm-3">
                                        <small id="passwordHelp" class="text-danger">
                                            <form:errors path="password"/>
                                        </small>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-12">
                                        <button name="submit" type="submit" class="btn btn-primary col-12">Login</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<nav class="navbar navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="/admin/list-category">Admin page</a>
    <c:if test="${loginUser != null}">
        <a class="navbar-brand" href="/logout">Logout</a>
    </c:if>
</nav>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="price" required="true" type="java.lang.Float" %>

<h2>
    <fmt:formatNumber value="${price}" type="currency"/>
</h2>

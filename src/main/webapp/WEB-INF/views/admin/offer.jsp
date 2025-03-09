<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/9/2025
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offer</title>
    <script async defer src="https://unpkg.com/@tailwindcss/browser@4"></script>

</head>
<body>
<%@ include file="../components/sidebar.jsp" %>
<div class="ml-[300px] mr-[16px] my-[16px]">
    <h1 class="text-2xl font-bold text-gray-900 mb-6">
        <c:if test="${offer == null}" >
            Add Offer
        </c:if>
        <c:if test="${offer != null}" >
            Edit Offer
        </c:if>
    </h1>
    <%@ include file="../components/offer_form.jsp" %>
</div>
</body>
</html>

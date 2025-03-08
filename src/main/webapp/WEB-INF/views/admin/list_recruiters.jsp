<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/8/2025
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Recruiters</title>
    <script async defer src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body>
<%@ include file="../components/sidebar.jsp" %>
<div class="ml-[300px] mr-[16px] my-[16px]">
    <div class="flex items-center justify-between">
    <h1 class="text-2xl font-bold text-gray-900 mb-6">List Recruiters</h1>
        <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
            <a href="recruiter/add-form" >
                Add Recruiter
            </a>
        </button>
    </div>
    <%@ include file="../components/users_table.jsp"%>
</div>
</body>
</html>

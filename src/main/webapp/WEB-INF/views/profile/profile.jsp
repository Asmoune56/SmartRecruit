<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/9/2025
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <script async defer src="https://unpkg.com/@tailwindcss/browser@4"></script>
</head>
<body class="bg-gray-50">
<%@ include file="../components/sidebar.jsp" %>

<div class="ml-[256px]">

<div class="flex-1 bg-gray-50">
    <div class="relative h-[200px] md:h-[350px]">
        <img
                src="https://images.unsplash.com/photo-1707343843437-caacff5cfa74?q=80&w=2940&auto=format&fit=crop"
                alt="Cover"
                class="w-full h-full object-cover"
        />

        <div class="absolute -bottom-20 left-8">
            <div class="relative">
                <img
                        src="https://images.unsplash.com/photo-1633332755192-727a05c4013d?q=80&w=2940&auto=format&fit=crop"
                        alt="Profile"
                        class="w-32 h-32 md:w-40 md:h-40 rounded-full border-4 border-white object-cover"
                />
            </div>
        </div>
    </div>

    <div class="mt-24 px-8">
        <div class="max-w-4xl">
            <h1 class="text-3xl font-bold text-gray-900"><c:out value="${sessionScope.user.lastName} ${sessionScope.user.firstName}" /></h1>
            <p class="text-gray-600 mt-1">
                <c:choose>
                    <c:when test="${sessionScope.utype == 'recruiter'}">
                        <c:out value="${sessionScope.user.companyName}" />
                    </c:when>
                    <c:when test="${sessionScope.utype == 'employee'}">
                        <c:out value="${sessionScope.user.domain}" />
                    </c:when>
                    <c:otherwise>
                        Admin
                    </c:otherwise>
                </c:choose>
            </p>

            <div class="mt-6 grid grid-cols-1 md:grid-cols-2 gap-6">
                <div class="space-y-4">
                    <p class="text-gray-700">
                        Passionate about building great software and solving complex problems.
                        Always learning and exploring new technologies.
                    </p>

                    <div class="space-y-2">
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M20 10c0 6-8 12-8 12s-8-6-8-12a8 8 0 0 1 16 0Z" />
                                <circle cx="12" cy="10" r="3" />
                            </svg>
                            <span>San Francisco, CA</span>
                        </div>
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <rect width="20" height="16" x="2" y="4" rx="2" />
                                <path d="m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7" />
                            </svg>
                            <span><c:out value="${sessionScope.user.email}" /></span>
                        </div>
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <rect width="18" height="18" x="3" y="4" rx="2" ry="2" />
                                <line x1="16" x2="16" y1="2" y2="6" />
                                <line x1="8" x2="8" y1="2" y2="6" />
                                <line x1="3" x2="21" y1="10" y2="10" />
                            </svg>
                            <span>Joined <c:out value="${sessionScope.user.createdAt}" /></span>
                        </div>
                    </div>
                </div>

                <div class="space-y-4">
                    <div class="space-y-2">
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M10 13a5 5 0 0 0 7.54.54l3-3a5 5 0 0 0-7.07-7.07l-1.72 1.71" />
                                <path d="M14 11a5 5 0 0 0-7.54-.54l-3 3a5 5 0 0 0 7.07 7.07l1.71-1.71" />
                            </svg>
                            <a href="#" class="text-blue-600 hover:underline">portfolio.com</a>
                        </div>
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M22 4s-.7 2.1-2 3.4c1.6 10-9.4 17.3-18 11.6 2.2.1 4.4-.6 6-2C3 15.5.5 9.6 3 5c2.2 2.6 5.6 4.1 9 4-.9-4.2 4-6.6 7-3.8 1.1 0 3-1.2 3-1.2z" />
                            </svg>
                            <a href="#" class="text-blue-600 hover:underline">@johndoe</a>
                        </div>
                        <div class="flex items-center text-gray-600">
                            <svg class="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M15 22v-4a4.8 4.8 0 0 0-1-3.5c3 0 6-2 6-5.5.08-1.25-.27-2.48-1-3.5.28-1.15.28-2.35 0-3.5 0 0-1 0-3 1.5-2.64-.5-5.36-.5-8 0C6 2 5 2 5 2c-.3 1.15-.3 2.35 0 3.5A5.403 5.403 0 0 0 4 9c0 3.5 3 5.5 6 5.5-.39.49-.68 1.05-.85 1.65-.17.6-.22 1.23-.15 1.85v4" />
                                <path d="M9 18c-4.51 2-5-2-7-2" />
                            </svg>
                            <a href="#" class="text-blue-600 hover:underline">github.com/johndoe</a>
                        </div>
                    </div>

                    <div class="bg-white p-4 rounded-lg shadow-sm">
                        <h3 class="font-semibold text-gray-900 mb-2">Quick Stats</h3>
                        <div class="grid grid-cols-3 gap-4 text-center">
                            <div>
                                <div class="text-xl font-bold text-gray-900">142</div>
                                <div class="text-sm text-gray-600">Projects</div>
                            </div>
                            <div>
                                <div class="text-xl font-bold text-gray-900">10.2k</div>
                                <div class="text-sm text-gray-600">Followers</div>
                            </div>
                            <div>
                                <div class="text-xl font-bold text-gray-900">3.5k</div>
                                <div class="text-sm text-gray-600">Following</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>


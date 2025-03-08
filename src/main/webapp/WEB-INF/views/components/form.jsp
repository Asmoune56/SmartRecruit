<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/7/2025
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="mt-10 w-[600px]">
    <c:if test="${user == null}">
        <form class="space-y-6 w-full" action="/auth/register" method="POST">
    </c:if>
    <c:if test="${user != null}">
        <form class="space-y-6 w-full" action="/auth/edit" method="POST">
    </c:if>
        <div class="flex gap-2 items-center">
            <div class="grow">
                <label for="fname" class="block text-sm/6 font-medium text-gray-900">First Name</label>
                <div class="mt-2">
                    <input value="<c:out value="${user.firstName}" />" type="text" name="fname" id="fname"  required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
                </div>
            </div>

            <div class="grow">
                <label for="lname" class="block text-sm/6 font-medium text-gray-900">Last Name</label>
                <div class="mt-2">
                    <input value="<c:out value="${user.lastName}" />" type="text" name="lname" id="lname"  required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
                </div>
            </div>
        </div>
        <div>
            <label for="bdate" class="block text-sm/6 font-medium text-gray-900">Birth Date</label>
            <div class="mt-2">
                <input value="<c:out value="${user.birthdate}" />" type="date" name="bdate" id="bdate" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>

        <c:if test="${type == 'recruiter'}">
            <div>
                <label for="companyName" class="block text-sm/6 font-medium text-gray-900">Company Name</label>
                <div class="mt-2">
                    <input value="<c:out value="${user.companyName}" />" type="text" name="companyName" id="companyName" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
                </div>
            </div>
        </c:if>

        <div>
            <label for="email" class="block text-sm/6 font-medium text-gray-900">Email address</label>
            <div class="mt-2">
                <input value="<c:out value="${user.email}" />" type="email" name="email" id="email" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>

        <div>
            <label for="password" class="block text-sm/6 font-medium text-gray-900">Password</label>
            <div class="mt-2">
                <input value="<c:out value="${user.password}" />" type="password" name="password" id="password" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>

        <input hidden="hidden" value="${redirect}" name="redirect" />
        <input hidden="hidden" value="${type}" name="utype" />


        <c:if test="${user == null}">
            <input hidden="hidden" name="userId" value="<c:out value="${user.userId}" />" />
        </c:if>


        <div>
            <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-xs hover:bg-indigo-500 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                <c:if test="${user == null}">
                    Add User
                </c:if>
                <c:if test="${user != null}">
                    Edit User
                </c:if>
            </button>
        </div>
    </form>
</div>

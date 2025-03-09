<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/9/2025
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="mt-10 w-[600px]">
    <c:if test="${offer == null}">
        <form class="space-y-6 w-full" action="/offer/add" method="POST">
    </c:if>
    <c:if test="${offer != null}">
        <form class="space-y-6 w-full" action="/offer/edit" method="POST">
    </c:if>
        <div>
            <label for="title" class="block text-sm/6 font-medium text-gray-900">Title</label>
            <div class="mt-2">
                <input value="<c:out value="${offer.title}" />" type="text" name="title" id="title" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>
        <div>
            <label for="desc" class="block text-sm/6 font-medium text-gray-900">Description</label>
            <div class="mt-2">
                <textarea value="<c:out value="${offer.description}" />"  name="desc" id="desc" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6" ></textarea>
            </div>
        </div>
        <div>
            <label for="price" class="block text-sm/6 font-medium text-gray-900">Price</label>
            <div class="mt-2">
                <input value="<c:out value="${offer.price}" />" type="number" name="price" id="price" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>
        <div>
            <label for="category" class="block text-sm/6 font-medium text-gray-900">Category</label>
            <div class="mt-2">
                <input value="<c:out value="${offer.category}" />" type="text" name="category" id="category" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
            </div>
        </div>

            <c:if test="${offer != null}">
                <input hidden="hidden" name="id" value="<c:out value="${offer.id}" />">
            </c:if>

        <div>
            <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-xs hover:bg-indigo-500 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">
                <c:if test="${offer == null}">
                    Add Offer
                </c:if>
                <c:if test="${offer != null}">
                    Edit Offer
                </c:if>
            </button>
        </div>

    </form>
</div>

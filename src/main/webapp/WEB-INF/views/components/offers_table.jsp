<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/9/2025
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="bg-white rounded-lg shadow mb-8">
    <div class="px-6 py-4 border-b border-gray-200">
        <h2 class="text-lg font-semibold text-gray-900">Team Members</h2>
    </div>
    <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3" />
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Title</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Description</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">price</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Category</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Created By</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Created At</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Last Update</th>
                <th class="relative px-6 py-3">
                    <span class="sr-only">Actions</span>
                </th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">

            <c:forEach var="offer" items="${offers}" >
                <tr  class="hover:bg-gray-50 transition-colors">
                    <!-- Offer Id -->
                    <td class="px-6 py-4 whitespace-nowrap"><c:out value="${offer.id}" /></td>
                    <!-- Title -->
                    <td class="px-6 py-4 whitespace-nowrap">
                        <div class="text-sm text-gray-500"><c:out value="${offer.title}" /></div>
                    </td>
                    <!-- Desc -->
                    <td class="px-6 py-4 whitespace-nowrap">
                        <div class="text-sm text-gray-500"><c:out value="${offer.description}" /></div>
                    </td>
                    <!-- Price -->
                    <td class="px-6 py-4 whitespace-nowrap">
                        <div class="text-sm text-gray-500"><c:out value="${offer.price}" /></div>
                    </td>
                    <!-- Category -->
                    <td class="px-6 py-4 whitespace-nowrap">
                        <div class="text-sm text-gray-500"><c:out value="${offer.category}" /></div>
                    </td>
                    <!--Created by-->
                    <td class="px-6 py-4 whitespace-nowrap">
                        <div class="text-sm text-gray-500"><c:out value="${offer.createdBy.firstName} ${offer.createdBy.lastName}" /></div>
                    </td>

                    <!-- offer Created at-->
                    <td class="px-6 py-4 whitespace-nowrap">
                      <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                        <c:out value="${offer.createdAt}" />
                      </span>
                    </td>
                    <!-- offer Updated at-->
                    <td class="px-6 py-4 whitespace-nowrap">
                      <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                        <c:out value="${offer.updatedAt}" />
                      </span>
                    </td>
                    <!-- Actions-->
                    <td class="px-6 py-4 whitespace-nowrap text-left text-sm font-medium">
                        <a href="/offer/delete?id=<c:out value="${offer.id}" />">Delete</a>
                        <a class="ml-3" href="offer/edit-form?id=<c:out value="${offer.id}" />">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

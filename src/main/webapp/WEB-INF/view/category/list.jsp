<%-- 
    Document   : list
    Created on : Nov 14, 2020, 11:26:10 PM
    Category     : popelos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category List</title>
        <!--<link rel="stylesheet" href="styling/styling.css" />-->
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            

            <p>
                ${categoryMessage}
            </p>
            <div class="t_holder">
                <h2>List Of Categories</h2>
                <div class="btn-area">
                    <a class="btn" href="${pageContext.request.contextPath}/category/create">Create A New Category</a> 
                </div>
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.name}</td>
                                <td class="buttontd"><a class="btn" href="category/edit?id=${category.id}">Edit</a></td>
                                <td class="buttontd"><a class="btn" href="category/delete?id=${category.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>

    </body>
</html>
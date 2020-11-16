<%-- 
    Document   : list
    Created on : Nov 14, 2020, 11:26:10 PM
    Book     : popelos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <!--<link rel="stylesheet" href="styling/styling.css" />-->
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="t_holder">
                <h2>List Of Books</h2>
                <div class="btn-area">
                    <a  class="btn" href="${pageContext.request.contextPath}/book/create">Create A New Book</a> 
                </div>
                <p>
                    ${bookMessage}
                </p>
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>ISBN</th>
                            <th>Price</th>
                            <th colspan="2">Author</th>
                            <th>Category</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${books}" var="book">
                            <tr>
                                <td>${book.id}</td>
                                <td>${book.title}</td>
                                <td>${book.isbn}</td>
                                <td>${book.price}$</td>
                                <td>${book.aid.firstName}</td>
                                <td>${book.aid.lastName}</td>
                                <td>${book.cid.name}</td>
                                <td class="buttontd"><a class="btn" href="book/edit?id=${book.id}">Edit</a></td>
                                <td class="buttontd"><a class="btn" href="book/delete?id=${book.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>

    </body>
</html>
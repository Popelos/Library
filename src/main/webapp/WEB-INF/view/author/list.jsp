<%-- 
    Document   : list
    Created on : Nov 14, 2020, 11:26:10 PM
    Author     : popelos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Author List</title>
        <!--<link rel="stylesheet" href="styling/styling.css" />-->
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <div class="t_holder">
                <h2>List Of Authors</h2>
                <div class="btn-area">
                    <a  class="btn" href="${pageContext.request.contextPath}/author/create">Create A New Author</a> 
                </div>
                <p>
                    ${authorMessage}
                </p>
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Date of birth</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <c:forEach items="${authors}" var="author">
                            <tr>
                                <td>${author.id}</td>
                                <td>${author.firstName}</td>
                                <td>${author.lastName}</td>
                                <td>${author.dateOfBirth}</td>
                                <td class="buttontd"><a class="btn" href="author/edit?id=${author.id}">Edit</a></td>
                                <td class="buttontd"><a class="btn" href="author/delete?id=${author.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>

    </body>
</html>
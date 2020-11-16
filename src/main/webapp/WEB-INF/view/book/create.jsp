<%-- 
    Document   : create
    Created on : Oct 30, 2020, 8:20:11 PM
    Book     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Book</title>
        <!--<link rel="stylesheet" href="../styling/styling.css" />-->
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container" >
            <h2>Create Book</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/book/create" 
                       modelAttribute="book" 
                       method="POST">
                <div>
                    <label for="title">Enter title</label>
                    <form:input id="title" path="title"/>
                </div>
                <div>
                    <label for="isbn">Enter ISBN</label>
                    <form:input id="isbn" path="isbn"/>
                </div>
                <div>
                    <label for="price">Enter price</label>
                    <form:input ud="price" path="price"/>
                </div>
                <div>
                    <label for="aid">Seletct Author</label>
                    <form:select path="aid" items="${authors}" itemLabel="fullName" itemValue="id" />
                </div>
                <div>
                    <label for="cid">Seletct Category</label>
                    <form:select path="cid" items="${categories}" itemLabel="name" itemValue="id" />
                </div>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>
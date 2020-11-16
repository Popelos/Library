<%-- 
    Document   : edit
    Created on : Oct 30, 2020, 8:55:31 PM
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="../styling/styling.css" />-->
        <title>Edit Category</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>Create Category</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/category/edit" 
                       method="POST"
                       modelAttribute="category">
                <label for="id">Id</label>
                <form:input id="id" path="id" readonly="true"/>
                <label for="name">Name</label>
                <form:input id="name" path="name"/>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>
        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>

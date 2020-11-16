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
        <title>Edit Book</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>Create Book</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/book/edit" 
                       method="POST"
                       modelAttribute="book">
                <label for="id">Id</label>
                <form:input id="id" path="id" readonly="true"/>
                
                <label for="title">Title</label>
                <form:input id="title" path="title"/>
                
                <label for="isbn">ISBN</label>
                <form:input id="isbn" path="isbn"/>
                
                <label for="price">Price</label>
                <form:input id="price" path="price"/>
                
                <label for="aid">First Name</label>
                <form:input id="aid" path="aid.firstName"/>
                
                <label for="aid">Last Name</label>
                <form:input id="aid" path="aid.lastName"/>
                
                <label for="cid">Category</label>
                <form:input id="cid" path="cid.name"/>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>
        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>

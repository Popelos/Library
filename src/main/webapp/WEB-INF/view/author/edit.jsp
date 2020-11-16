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
        <title>Edit Author</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <section class="container">
            <h2>Create Author</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/author/edit" 
                       method="POST"
                       modelAttribute="author">
                <label for="id">Id</label>
                <form:input id="id" path="id" readonly="true"/>
                
                <label for="firstName">First name</label>
                <form:input id="firstName" path="firstName"/>
                
                <label for ="lastName">Last name</label>
                <form:input id="lastName" path="lastName"/>
                
                <label for ="dateOfBirth">Birthdate</label>
                <form:input id="dateOfBirth" path="dateOfBirth"/>
                
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>
        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>

<%-- 
    Document   : create
    Created on : Oct 30, 2020, 8:20:11 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Author</title>
        <!--<link rel="stylesheet" href="../styling/styling.css" />-->
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Create Author</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/author/create" 
                       modelAttribute="author" 
                       method="POST">
                <div>
                    <label for="sname">Enter first name</label>
                    <form:input id="firstName" path="firstName"/>
                    <%--<form:errors path="sname"/>--%>
                </div>
                <div>
                    <label for="lastName">Enter last name</label>
                    <form:input id="lastName" path="lastName"/>
                    <%--<form:errors path="scity"/>--%>
                </div>
                <div>
                    <label for="dateOfBirth">Enter birthdate</label>
                    <form:input ud="dateOfBirth" path="dateOfBirth"/>
                   <%--<form:errors path="scomm"/>--%>
                </div>

                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>
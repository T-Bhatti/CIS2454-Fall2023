<%-- 
    Document   : recipe
    Created on : Nov 13, 2023, 2:56:02 PM
    Author     : tahre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipe</title>
    </head>
    <body>
        
        <h2>Ingredients:</h2>
        <c:forEach var="ingredient" items="${ingredients}">
            <p>${ingredient.toString()}</p>
        </c:forEach>
            <h3>Direction:</h3>
            <p>${direction}</p>
    </body>
</html>

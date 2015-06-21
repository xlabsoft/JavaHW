<%-- 
    Document   : all
    Created on : 25.05.2015, 20:25:53
    Author     : Shamen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${goods}" var="good">
            <div>${good.name} = ${good.price}</div>
        </c:forEach>
    </body>
</html>

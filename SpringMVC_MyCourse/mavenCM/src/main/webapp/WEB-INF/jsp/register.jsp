<%-- 
    Document   : register
    Created on : 21.06.2015, 18:53:52
    Author     : Shamen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register new user</h1>
        <div>
            <form method="GET" action="<c:url value="/user/userSave"/>
            <input type="hidden" name="id" />
            <label for="name">Name:</label>
            <input type="text" name="name" />
            <label for="email">Email:</label>
            <input type="text" name="email" />
            <label for="password">Password:</label>
            <input type="text" name="password" />
            <label for="isAdmin">Is admin:</label>
            <input type="checkbox" name="isAdmin" value="1"/>
            <input type="submit" />
        </form>
        </div>
    </body>
</html>

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
        <!--c:forEach items="${goods}" var="good"-->
            <!--div>${good.name} = ${good.price}</div-->
        <!--/c:forEach-->
        <div class="container">
            <div class="jumbotron">
                <h1>${current.name}'s Contacts</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">

                        
                        <div class="panel-body">
                            <table border="1">
                                <tbody>
                                    <tr>
                                        <td>Name</td>
                                        <td>OffName</td>
                                        <td>Company</td>
                                    </tr>
                                    <c:forEach items="${contacts}" var="contact">
                                        <tr>
                                            <td>${contact.name}</td>
                                            <td>${contact.oname}</td>
                                            <td> ${contact.company}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
</div>
                        </div>
                    </div>
                </div>




            </div>
        </div>



    </body>
</html>

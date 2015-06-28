<%-- 
    Document   : all
    Created on : 25.05.2015, 20:25:53
    Author     : Shamen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <table> <!-- border="1"-->
                                <tbody>
                                    <tr style="height: 30px; background: #333; color: #7fffd4;">
                                        <td style="padding-right:30px;">Name</td>
                                        <td style="padding-right:30px;">OffName</td>
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
    </tiles:putAttribute>
</tiles:insertDefinition>
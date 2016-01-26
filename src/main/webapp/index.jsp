<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:16:39 PM
    Author     : c0663965
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsample.DBsample" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=DBsample.getTable()%>
    </body>
</html>

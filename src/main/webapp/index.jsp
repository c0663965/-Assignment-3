<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:16:39 PM
    Author     : Kihoon, Lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsample.DBsample" %>

<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1>Hello Hello W   orld!</h1>

    <%DBsample.createTable();%>
     <%DBsample.insertData();%>
      <%=DBsample.getTable()%>

</html>

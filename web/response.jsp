<%-- 
    Document   : response
    Created on : Oct 31, 2016, 7:23:46 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="aa.ebookshop.NameHandler" />
        <jsp:setProperty name="mybean" property="name" />
        <h1>Hello, <jsp:getProperty name="mybean" property="name" />    !</h1>
    </body>
</html>

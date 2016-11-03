<%-- 
    Document   : response.jsp
    Created on : Nov 3, 2016, 10:40:15 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response Page</title>
    </head>
    <body>
        
        <jsp:useBean id="mybean" scope="session" class="aa.TestJavaBeans.NameHandler" />
        <jsp:setProperty name="mybean" property="name" />
        <h1>Hello <jsp:getProperty name="mybean" property="name" />  !</h1>
    </body>
</html>

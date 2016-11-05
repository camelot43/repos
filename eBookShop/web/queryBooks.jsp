<%-- 
    Document   : queryBooks
    Created on : Nov 4, 2016, 11:25:02 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Books Page</title>
    </head>
    <body>
        <h1>Query Books!</h1>
        <form name="query" action="queryBooks">
            Book Name:
            <input type="text" name="book" value="" />
            <br />
            Author Name:
            <input type="text" name="author" value="" />
            <br />
            <input type="submit" value="Search" name="SearchButton" />
        </form>
    </body>
</html>

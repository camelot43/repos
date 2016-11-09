<%-- 
    Document   : index.jsp
    Created on : Nov 3, 2016, 11:17:14 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eBookShop</title>
        <link rel="stylesheet" href="stylesheets/main.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400">
    </head>


    <body>

        <%@ include file="navigation.jsp" %>

        <section class="row-alt">
            <div class="lead container">
                <h1>Index</h1>
                <p>Login or Select from the Menu above</p>
            </div>
        </section>



        <footer class="primary-footer container group">

            <small>&copy; E-Book Shop</small>

            <nav class="nav">
                <ul>
                    <li><a href="index.jsp">Home</a></li><!--
                    --><li><a href="Context">Context</a></li><!--
                    --><li><a href="queryBooks.jsp">Query Books</a></li>
                </ul>
            </nav>

        </footer>


    </body>
</html>

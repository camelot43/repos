<%-- 
    Document   : bookResults
    Created on : Nov 5, 2016, 11:47:43 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookResults</title>
        <link rel="stylesheet" href="stylesheets/main.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400">
    </head>


    <body>

        <header class="primary-header container group">

            <h1 class="logo">
                <a href="index.jsp">E-Book Shop</a>
            </h1>

            <h3 class="tagline">Lisbon, PT</h3>

            <nav class="nav primary-nav">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="Context">Context</a></li>
<!--                    <li><a href="queryBooks.jsp">Query Books</a></li>-->
                    <li><a href="controllerExample?todo=startQuery">Query Books</a></li>
                    <li><a href="controllerExample?todo=aa">Controller Example</a></li>
                </ul>
            </nav>

        </header>

        <table border="600" cellspacing="20" cellpadding="40">
            <thead>
                <tr>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>aaaaaaa</td>
                    <td>bbbbbbbbbb</td>
                    <td>ccccccccccccccccc</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>



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

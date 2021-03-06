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
        <title>eBookShop</title>
        <link rel="stylesheet" href="stylesheets/main.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400">
    </head>


    <body>

        <%@ include file="navigation.jsp" %>
        
        <section class="row-alt">
            <div class="lead container">
                <h1>Query for Book</h1>
                <p>Enter a combination of book title and Author Name. Click Search</p>

                <!--        <form class="col-1-3" action="queryBooks" method="post">-->
                <form class="col-1-3" action="controllerExample" method="post">
                    <fieldset class="query-group">
                        <input type="hidden" name="todo" value="queryBook" />

                        <label>
                            Book Name:
                            <input type="text" name="book" placeholder="Book title" required>
                        </label>

                        <label>
                            Author Name:
                            <input type="text" name="author" placeholder="Author name">
                        </label>

                    </fieldset>

                    <input class="btn btn-default" type="submit" name="submit" value="Search">

                </form>


            </div>
        </section>








        <footer class="primary-footer container group">

            <small>&copy; E-Book Shop</small>

            <nav class="nav">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="Context">Context</a></li>
                    <li><a href="queryBooks.jsp">Query Books</a></li>
                </ul>
            </nav>

        </footer>


    </body>    

</html>

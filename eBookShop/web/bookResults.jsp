<%-- 
    Document   : bookResults
    Created on : Nov 5, 2016, 11:47:43 PM
    Author     : aanciaes
--%>

<%@page import="aa.eBookShop.Services.book"%>
<%@page import="java.util.List"%>
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

        <%@ include file="navigation.jsp" %>
        
        <section class="row-alt">
            <div class="lead container">


                <%
                    // Check whether the list of books is empty.
                    List<book> theBooks = (List<book>) request.getAttribute("queryResults");
                    if (theBooks != null && theBooks.size() > 0) {
                %>

                <table border="600" cellspacing="20" cellpadding="40">
                    <thead>
                        <tr>
                            <th>Author</th>
                            <th>Title</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            // Scriptlet 3: display the books in the shopping cart.
                            for (int i = 0; i < theBooks.size(); ++i) {
                                book abook = theBooks.get(i);
                        %>

                        <tr>
                            <td><%= abook.getAuthor()%></td>
                            <td><%= abook.getTitle()%></td>
                            <td><%= abook.getPrice()%></td>
                        </tr>
                        <%
                            } // for loop
                        %>
                    </tbody>
                </table>

                <%
                    }  // if
                %>


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

<%-- 
    Document   : ListPersons
    Created on : Dec 4, 2016, 6:56:19 PM
    Author     : aanciaes


http://www.quackit.com/bootstrap/bootstrap_3/tutorial/


--%>


<%@page import="java.util.List"%>
<%@page import="aa.PersonDog.model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Template by quackit.com -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>List Persons</title>
        <link rel="stylesheet" href="stylesheets/main.css">

        <!-- Viewport Meta Tag -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>

    <body>
        <div id="wrapper">

            <main>
                <div id="content">
                    <div class="innertube">

                        <!-- YOUR CONTENT GOES HERE -->
                        <div class="container">


                            <section id="tables">
                                <h2>List of Persons</h2>
                                <p>Result of search Persons.</p> 

                                <%
                                    // Check whether the list of books is empty.
                                    List<Person> thePersons = (List<Person>) request.getAttribute("queryResults");
                                    if (thePersons != null && thePersons.size() > 0) {
                                %>


                                <table class="table table-responsive">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Age</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <%
                                            // Scriptlet 3: display the books in the shopping cart.
                                            for (int i = 0; i < thePersons.size(); ++i) {
                                                Person aperson = thePersons.get(i);
                                        %>                                        

                                        <tr>
                                            <td><%= aperson.getId()%></td>
                                            <td><%= aperson.getName()%></td>
                                            <td><%= aperson.getAge()%></td>
                                        </tr>
                                        <%
                                            } // for loop
                                        %>

                                    </tbody>
                                </table>
                                <%
                                    }  // if
                                %>

                            </section>



                        </div>

                        <!-- JavaScript: placed at the end of the document so the pages load faster -->
                        <!-- JQuery -->
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                        <!-- Bootstrap JS -->
                        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


                    </div>
                </div>
            </main>

            <nav id="nav">
                <div class="innertube">

                    <%@ include file="menuOptions.jsp" %>

                </div>
            </nav>

        </div>
    </body>
</html>


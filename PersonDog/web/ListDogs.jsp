<%-- 
    Document   : ListPersons
    Created on : Dec 5, 2016, 10:19:00 PM
    Author     : aanciaes

Base on: http://www.quackit.com/bootstrap/bootstrap_3
--%>


<%@page import="aa.PersonDog.model.Dog"%>
<%@page import="java.util.List"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Dogs</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!-- Initialize Bootstrap functionality -->
        <script>
            // Initialize tooltip component
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })

            // Initialize popover component
            $(function () {
                $('[data-toggle="popover"]').popover()
            })
        </script>

    </head>
    <body>

        <%@ include file="navbar.jsp" %>

        <div class="container-fluid">

            <%
                // Check whether the list of books is empty.
                List<Dog> theDogs = (List<Dog>) request.getAttribute("queryResults");
                if (theDogs != null && theDogs.size() > 0) {
            %>

            <h1>Results</h1>
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
                        for (int i = 0; i < theDogs.size(); ++i) {
                            Dog aDog = theDogs.get(i);
                    %>                                        

                    <tr>
                        <td><%= aDog.getId()%></td>
                        <td><%= aDog.getName()%></td>
                        <td><%= aDog.getAge()%></td>
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

    </body>
</html>



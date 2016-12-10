<%-- 
    Document   : ListPersons
    Created on : Dec 5, 2016, 10:19:00 PM
    Author     : aanciaes

Base on: http://www.quackit.com/bootstrap/bootstrap_3
--%>


<%@page import="java.util.List"%>
<%@page import="aa.PersonDog.model.Person"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Persons</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="jquery-1.11.3/dist/jquery.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

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
                List<Person> thePersons = (List<Person>) request.getAttribute("queryResults");
                if (thePersons != null && thePersons.size() > 0) {
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
            else {
            %>
            <h1>Query did not retrieve any result</h1>
            <%
            }
            %>

        </div>

    </body>
</html>



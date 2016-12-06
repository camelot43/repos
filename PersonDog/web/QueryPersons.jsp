<%-- 
    Document   : QueryPersons
    Created on : Dec 5, 2016, 10:38:44 PM
    Author     : aanciaes

Base on: http://www.quackit.com/bootstrap/bootstrap_3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Persons</title>

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

            <form action="/PersonDog/Controller">
                <input type="hidden" name="todo" value="queryPersonByExample" />
                <div class="form-group">
                    <label for="person_name">Person Name</label>
                    <input type="text" class="form-control" id="person_name" name="person_name">
                </div>
                <div class="form-group">
                    <label for="person_age">Age</label>
                    <input type="number" class="form-control" id="person_age" name="person_age">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div>



    </body>
</html>




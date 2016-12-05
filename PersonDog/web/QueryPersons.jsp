<%-- 
    Document   : QueryPersons
    Created on : Dec 4, 2016, 11:57:45 PM
    Author     : aanciaes
--%>



<%@page import="aa.PersonDog.model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Template by quackit.com -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Query Persons</title>
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
                        <!-- Bootstrap CSS -->
                        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
                        <div class="container-fluid">

                            <form action="/html/tags/html_form_tag_action.cfm">
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



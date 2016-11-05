<%-- 
    Document   : login
    Created on : Nov 5, 2016, 8:11:32 PM
    Author     : aanciaes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
            <link rel="stylesheet" href="stylesheets/main.css">
            <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400">
        </head>


        <body>

            <header class="primary-header container group">

                <h1 class="logo">
                    <a href="index.jsp">E-Book Shop</a>
                </h1>

                <h3 class="tagline">Lisbon, PT</h3>

            </header>

            <section class="row-alt">
                <div class="lead container">
                    <h1>Login</h1>
                    <p>Enter your userID and Password</p>
                </div>
            </section>


            <form class="col-1-3" action="j_security_check" method="POST">

                <fieldset class="query-group">
                    <label>
                        User ID:
                        <input type="text" name="j_username" value="" />
                    </label>
                    <label>
                        Password:
                        <input type="password" name="j_password" value="" />
                    </label>
                    <input class="btn" type="submit" value="Go" />

                </fieldset>
            </form>


            <footer class="primary-footer container group">
                <small>&copy; E-Book Shop</small>
            </footer>


        </body>

    </html>

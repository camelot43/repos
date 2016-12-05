<%-- 
    Document   : index
    Created on : Nov 25, 2016, 11:07:17 PM
    Author     : aanciaes
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Template by quackit.com -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Person Dogs Application</title>
        <link rel="stylesheet" href="stylesheets/main.css">		
        <script type="text/javascript">
            /* =============================
             This script generates sample text for the body content. 
             You can remove this script and any reference to it. 
             ============================= */
            var bodyText = ["The smaller your reality, the more convinced you are that you know everything.", "If the facts don't fit the theory, change the facts.", "The past has no power over the present moment.", "This, too, will pass.", "</p><p>You will not be punished for your anger, you will be punished by your anger.", "Peace comes from within. Do not seek it without.", "<h3>Heading</h3><p>The most important moment of your life is now. The most important person in your life is the one you are with now, and the most important activity in your life is the one you are involved with now."]
            function generateText(sentenceCount) {
                for (var i = 0; i < sentenceCount; i++)
                    document.write(bodyText[Math.floor(Math.random() * 7)] + " ")
            }
        </script>	

    </head>

    <body>
        <div id="wrapper">

            <main>
                <div id="content">
                    <div class="innertube">
                        <h1>Heading</h1>
                        <p><script>generateText(30)</script></p>
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


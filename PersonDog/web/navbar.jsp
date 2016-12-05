<%-- 
    Document   : navbar
    Created on : Dec 5, 2016, 10:05:35 PM
    Author     : aanciaes

Base on: http://www.quackit.com/bootstrap/bootstrap_3
--%>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <!-- BRAND -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#alignment-example" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Person Dog</a>
        </div>

        <!-- COLLAPSIBLE NAVBAR -->
        <div class="collapse navbar-collapse" id="alignment-example">

            <!-- Links -->
            <ul class="nav navbar-nav">
<!--                <li><a href="#">Link 1</a></li>
                <li><a href="#">Link 2</a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Persons<span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="persons">
                        <li><a href="/PersonDog/Controller?todo=listAllPersons">List all</a></li>
                        <li><a href="/PersonDog/QueryPersons.jsp">Query by Example</a></li>
                    </ul>
                </li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dogs<span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="dogs">
                        <li><a href="#">List all</a></li>
                        <li><a href="#">Query by Example</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
                    <ul class="dropdown-menu" aria-labelledby="manage">
                        <li><a href="/PersonDog/Controller?todo=insertDefaultData">Insert Default data</a></li>
                    </ul>
                </li>                
            </ul>


        </div>

    </div>
</nav>


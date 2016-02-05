<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 25/01/2016
  Time: 19.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="newpackage.TipoOfferta"%>
<html>

    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
        <link href="/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <!-- Dropdown Structure -->
        <ul id="dropdown1" class="dropdown-content">
            <li><a href="FindEvento.jsp"><%=TipoOfferta.OffertaEvento%></a></li>
            <li><a href="FindPernotto.jsp"><%=TipoOfferta.OffertaPernotto%></a></li>
            <li><a href="FindTrasporto.jsp"><%=TipoOfferta.OffertaTrasporto%></a></li>
        </ul>
        <nav>
            <div class="nav-wrapper">
                <a href="Catalogo.jsp" class="brand-logo">Catalogo</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="Pagamento.jsp">Carrello</a></li>
                    <li><a href="FindEvento.jsp"><%=TipoOfferta.OffertaEvento%></a></li>
                    <li><a href="FindPernotto.jsp"><%=TipoOfferta.OffertaPernotto%></a></li>
                    <li><a href="FindTrasporto.jsp"><%=TipoOfferta.OffertaTrasporto%></a></li>
                    <li><a href="GestioneUtente.jsp">Gestione utente</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <!-- Dropdown Trigger
                    <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Ricerca<i class="material-icons right">arrow_drop_down</i></a></li>-->
                </ul>
            </div>
        </nav>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <!--<script src="/js/init.js"></script>-->
    </body>
</html>

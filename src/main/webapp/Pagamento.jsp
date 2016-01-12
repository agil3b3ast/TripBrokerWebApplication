<%@ page import="newpackage.EntityPackage.*" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/01/2016
  Time: 23.01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="carrelloBean" scope="session"
             type="newpackage.CarrelloBean" />

<%
    if(request.getParameter("pay") != null){
        if(request.getParameter("pay").equals("pay")){
            if(!carrelloBean.Pay()){%>

    <div class="row">
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">Pagamento non riuscito per le seguenti offerte e/o pacchetti</span>
            </div>
        </div>
        <form action="Catalogo.jsp" name="myform8" method="post">
            <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>

    <%}}}
    if(request.getParameter("packetitem") != null){
        System.out.println(request.getParameter("packetitem").equals("ciao"));
    }
    if(request.getParameter("enter") != null){
        System.out.println(request.getParameter("enter").equals("enter"));
        System.out.println(request.getParameter("enter"));
    }
%>


<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Pagamento</title>
    </head>
    <body>

        <%for(OffertaEvento ofe : carrelloBean.getOfferEventolist()){%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=ofe.getNome()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=ofe.getDataScadenza()%></li>
                    <li>Prezzo <%=ofe.getPrezzo()%></li>
                </ul>
            </div>
        </div>
        <%}%>

        <%for(OffertaPernotto ofp : carrelloBean.getOfferPernottoArrayList()){%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=ofp.getNome()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=ofp.getDataScadenza()%></li>
                    <li>Prezzo <%=ofp.getPrezzo()%></li>
                </ul>
            </div>
        </div>
        <%}%>

        <%for(OffertaTrasporto oft : carrelloBean.getOffertaTrasportoArrayList()){%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=oft.getNome()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=oft.getDataScadenza()%></li>
                    <li>Prezzo <%=oft.getPrezzo()%></li>
                </ul>
            </div>
        </div>
        <%}%>

        <%for(Pacchetto p : carrelloBean.getPacketlist()){%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Pacchetto <%=p.getNome()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Prezzo <%=p.getPrezzo()%></li>
                </ul>
            </div>
        </div>
        <%}
        if(!carrelloBean.carrelloempty()){
        %>
         <form action="Pagamento.jsp" name="myform3" method="post">
            <input hidden value="pay" type="text" name="pay">
            <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                <i class="material-icons right">send</i>
            </button>
        </form>
        <%}else{%>
        <div class="row">
            <div class="card blue-grey">
                <div class="card-content white-text">
                    <span class="card-title">Carrello Vuoto</span>
                </div>
            </div>
            <form action="Catalogo.jsp" name="myform2" method="post">
                <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
        <%}%>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

    </body>
</html>

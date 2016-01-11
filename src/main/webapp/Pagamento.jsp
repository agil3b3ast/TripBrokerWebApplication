<%@ page import="newpackage.EntityPackage.Offerta" %>
<%@ page import="newpackage.EntityPackage.Pacchetto" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 10/01/2016
  Time: 23.01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<jsp:useBean id="carrelloBean" scope="request"
             class="newpackage.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if(request.getParameter("pay") != null){
        if(carrelloBean.Pay())
            System.out.println("Devo pagare");
    }
    if(carrelloBean.getPacketitem().equals("ciao")){
        System.out.println("Ciao");
    }
    if(request.getParameter("packetitem") != null){
        System.out.println("not null");
    }
    if(request.getParameter("enter") != null){
        System.out.println(request.getParameter("enter").equals("enter"));
        System.out.println(request.getParameter("enter"));
    }
%>


<html>
    <head>
        <title>Pagamento</title>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <%if(carrelloBean.getOfferlist() != null){
            for(Offerta of : carrelloBean.getOfferlist()){%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=of.getNome()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=of.getDataScadenza()%></li>
                    <li>Prezzo <%=of.getPrezzo()%></li>
                </ul>
            </div>
        </div>
        <%}}
        else if(carrelloBean.getPacketlist() != null){
            for(Pacchetto p : carrelloBean.getPacketlist()){%>
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
        <%}%>
            <form action="Pagamento.jsp" name="myform" method="post">
                <button class="btn-flat waves-effect waves-light" type="submit" id="pay" name="pay">Acquista
                    <i class="material-icons right">send</i>
                </button>
            </form>
        <%}
        else if(carrelloBean.getOfferlist() == null && carrelloBean.getPacketlist() == null){%>
            <div class="row">
                <div class="card blue-grey">
                    <div class="card-content white-text">
                        <span class="card-title">Carrello Vuoto</span>
                    </div>
                </div>
                <form action="Pagamento.jsp" name="myform2" method="post">
                    <input hidden value="ciao" type="text" name=packetitem" id="packetitem">
                    <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
                        <i class="material-icons right">send</i>
                    </button>
                </form>
            </div>
        <%}%>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

    </body>
</html>

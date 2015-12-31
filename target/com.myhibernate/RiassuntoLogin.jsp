<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="offertaBean" scope="request"
             class="newpackage.OffertaBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="offertaBean" property="*" />

<%
    if (offertaBean.getOftype() != null) {
        System.out.println("first not null");
        if (offertaBean.getOftype().equals("gigs") && !offertaBean.selectAll()) {
            System.out.println("not null");
        }
        else{System.out.println("null");}
    }
    else{System.out.println("first null");}
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
        <title>OK</title>
    </head>
    <body>
        <table align="center">
            <tbody>
            <tr>
                <td width="50%">
                    <ul class="collapsible" >
                        <li>
                            <form action="RiassuntoLogin.jsp" name="myform" method="post">
                                <input hidden value="gigs" name="oftype">
                                <button class="btn-flat waves-effect waves-light" type="submit">Submit
                                    <i class="material-icons right">send</i>
                                </button>
                            </form>
                            <!--<div input id="first" name="first" type="submit" class="collapsible-header">First</div>-->
                        </li>
                        <li>
                            <div class="collapsible-header">Second</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                        <li>
                            <div class="collapsible-header">Third</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                    </ul>
                </td>

                <td width="50%">
                    <ul class="collapsible" data-collapsible="expandable">
                        <% ArrayList<String[]> ls = offertaBean.getOfferList();
                            if(ls != null){
                            for(int i=0;i<ls.size();i++){%>
                        <li>
                            <div class="collapsible-header"><%=ls.get(i)[3]%></div>
                            <div class="collapsible-body"><div class="row"><div class="col"><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col"><p>Prezzo <%=ls.get(i)[5]%></p></div></div></div>
                        </li>
                        <%}}else{%>
                        <li>
                            <div class="collection-header">Selezionare almeno una delle opzioni</div>
                        </li>
                        <%}%>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

    </body>
</html>
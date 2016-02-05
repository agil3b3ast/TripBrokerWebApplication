<%@ page import="java.awt.*" %>
<%@ page import="javafx.stage.*" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 22/12/2015
  Time: 23.20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile utenteBean e istanzia un oggetto newpackage.utenteBean -->
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto utenteBean -->
<jsp:setProperty name="utenteBean" property="*" />


<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if(utenteBean.isLogged()){
%>

    <jsp:forward page="GestioneUtente.jsp"/>

<%  }
    if(request.getParameter("signUpNow") != null){
%>
    <jsp:forward page="SignUp.jsp"/>
<%}
    if (request.getParameter("login") != null) {
        if (utenteBean.logIn()) {
            //session.setAttribute("carrelloBean",carrelloBean);
            //session.setAttribute("utenteBean",utenteBean);
            utenteBean.setCarrelloBean(carrelloBean);
            carrelloBean.setUtenteBean(utenteBean);
%>
<!-- Passa il controllo alla nuova pagina -->
<jsp:forward page="GestioneUtente.jsp" />
<%
        }
    }
%>

<html>
<head>
    <title>Login</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="row">

            <div class="card-content blue-grey white-text">Benvenuto, questa è la pagina di login.<br>Non possiedi un account? Registrati subito!<br>
                <button class="btn waves-effect waves-light" type="submit" id="signUpNow" name="signUpNow">Registrati qui
                </button>
            </div>

            <form name="myform" method="post" action="login.jsp" class="col s12">
                <div class="row">
                    <div class="input-field col s12 black-text">
                        <input placeholder="mynickname" id="nickname" name="nickname" type="text" class="validate">
                        <label for="nickname">Nickname</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12 black-text">
                        <input placeholder="mypassword" id="password" name="password" type="text" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit" id="login" name="login">Submit
                    <i class="material-icons right">send</i>
                </button>

                <%
                    if (request.getParameter("login") != null) { %>
                <tr><td colspan=2 align="center"><p style="text-color:red;">Login non avvenuto, inserire correttamente le credenziali.<br>
                </p></td></tr>
                <% } %>
            </form>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>

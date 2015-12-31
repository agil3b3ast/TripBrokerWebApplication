<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 22/12/2015
  Time: 23.20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile loginBean e istanzia un oggetto newpackage.LoginBean -->
<jsp:useBean id="loginBean" scope="request"
             class="newpackage.LoginBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto loginBean -->
<jsp:setProperty name="loginBean" property="*" />

<%
    if (request.getParameter("login") != null) {
        if (loginBean.validate()) {
%>
<!-- Passa il controllo alla nuova pagina -->
<jsp:forward page="Eventi.jsp" />
<%
        }
        else{
%>

<jsp:forward page="login.jsp" />
<%
        }
    }
%>

<html>
<head>
    <title>Login</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
    <body>
        <div class="row">
            <form name="myform" method="post" action="login.jsp" class="col s12">
                <div class="row">

                    <div class="input-field col s12">
                        <input id="username" name="username" type="text" class="validate">
                        <label for="username">Username</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input id="password" name="password" type="password" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit" id="login" name="login">Submit
                    <i class="material-icons right">send</i>
                </button>

                <%
                    if (request.getParameter("login") != null) { %>
                <tr><td colspan=2 align="center"><p style="text-color:red;">Dati errati</p></td></tr>
                <% } %>
            </form>
        </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>

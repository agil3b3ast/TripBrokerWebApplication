<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 13/01/2016
  Time: 20.26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="findpernottoBean" scope="request"
             class="newpackage.OffertaPernottoBean"/>

<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="findpernottoBean" property="*"/>


<%
if(request.getParameter("findMyOverNight")!= null){
    findpernottoBean.fillToFind();
    }

%>
<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Trova Pernotto</title>
    </head>
    <body>
        <table align="center">
            <tbody>
            <tr>
                <td width="30%">
                    <jsp:include page="FormPernottoOffer.jsp"/>
                </td>
                <td width="20%"></td>
                <td width="50%">
                    <jsp:include page="OffertaPernottoResponse.jsp"/>
                </td>
            </tr>
            </tbody>
        </table>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>

    </body>
</html>

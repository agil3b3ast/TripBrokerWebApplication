<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 29/12/2015
  Time: 11.49
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


%>
<jsp:forward page="RiassuntoLogin.jsp" />

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

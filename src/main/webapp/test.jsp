<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 11/01/2016
  Time: 16.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(request.getParameter("sub") != null){
    System.out.println(request.getParameter("sub"));
}%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="test.jsp" name="myform" method="post">
            <input hidden value="ciao" type="text" name="sub">
            <button type="submit">
                Submit
            </button>
        </form>
    </body>
</html>

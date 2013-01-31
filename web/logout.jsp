<%-- 
    Document   : logout
    Created on : 06-ago-2012, 6:38:19
    Author     : CONNORS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrando Sesión</title>
    </head>
    <body>
        <h1>Cerrando Sesión</h1>
        <%
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            response.sendRedirect("iniciarSesion.jsp");
        %>
    </body>
</html>

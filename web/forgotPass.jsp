<%-- 
    Document   : forgotPass
    Created on : 01-ago-2012, 13:06:16
    Author     : CONNORS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/ajax.js" ></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            
            <p>Digite su correo Electrónico: </p><input type="text" name="correo" />
            <input type="button" onclick="enviarEmail('sendEmail.jsp')" value="Enviar" />
        </form>
        <p></p>
    </body>
</html>

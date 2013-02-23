<%-- 
    Document   : index
    Created on : 08-jul-2012, 18:26:02
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css" title="estilo"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
        
        <%
            if(request.getParameter("error") != null)
                out.println("<p style='color:#F00; text-align: center; top:100px'>"+request.getParameter("error") +"</p>");
        %>
        <div id ="login">
            <img src="imagen/logo.jpg" alt="Hotel Quinta Avenida" />
            <div class="data">
            <form name="login" action="login.jsp" method="POST">
                    <p> Usuario: </p><input type="text" name="usuario" value="" required/> 
                    <p> Contraseña: </p><input type="password" name="password" value="" required/> 
                    <p style="text-align: center;margin-left: -50px"><input type="submit" value="Ingresar" name="login" /></p>
                </form>
                <br>
                <p><a href="forgotPass.jsp">¿Olvidó su contraseña?</a></p>
            </div>
        </div>
    </body>
</html>

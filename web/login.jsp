<%-- 
    Document   : login
    Created on : 28/07/2012, 05:18:29 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logeando</title>
    </head>
    <body>
        <jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
        
        <%
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        int rol = fachada.validarUsuario(usuario,password);
        System.err.println(rol);
        if(rol != -1)
        {
            HttpSession sesion = request.getSession();
            
            String numRol = String.valueOf(rol);
            //si es usuario cargamos sus datos en la sesion para desplegar el menu
            sesion.setAttribute("rol", numRol );
            sesion.setAttribute("id", usuario);
            response.sendRedirect("user/usuario/fichaUsuario.jsp");
        }
        else
        {
            response.sendRedirect("iniciarSesion.jsp?error=Datos incorrectos");
        }    
        %>
    </body>
</html>

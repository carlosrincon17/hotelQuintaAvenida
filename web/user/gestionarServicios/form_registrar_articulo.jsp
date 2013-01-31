<%-- 
    Document   : form_registrar_articulo
    Created on : 01-ago-2012, 1:53:31
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<html>
    <head>
 <% 
        
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu");
        
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <title>Registrar Artículos - Hotel Quinta Avenida</title>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
        <div id="todo">  
        <div class="cabecera">
       
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
        
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Datos del nuevo articulo</div><br>
                    <form action="registrar_articulo.jsp">
                        <table class="formulario">
                            <tr>
                                <td><p>Nombre:</p></td>
                                <td><input type="text" name="nombre" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Precio:</p></td>
                                <td><input type="text" name="precio" value="" required/></td>
                            </tr>
                            <tr>
                                <td><p>Cantidad:</p></td>
                                <td><input type="text" name="cantidad" value="" required/></td>
                        </table>
            
                        <input type="submit" value="Registrar articulo" /><br><br>
                    </form>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>

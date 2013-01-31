<%-- 
    Document   : fichaUsuario
    Created on : 29/07/2012, 10:30:00 AM
    Author     : Jorge
--%>

<%@page import="com.sun.xml.internal.bind.v2.model.core.ID"%>
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
        <title>Crear Nuevo Rol - Hotel Quinta Avenida</title>
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
                    <div class="separador">Datos del nuevo rol</div>
                    <br><br>
                    <form name="creaRol.jsp" action="creaRol.jsp">
                        <table class="formulario">
                            <tr>
                                <td><p>Nombre :</p></td>
                                <td><input type="text" name="nombre" required></td>
                            </tr>
                            <tr>
                                <td><p>Descripcion: </p></td>
                                <td><input type="text" name="descripcion" required></td>
                            </tr>
                        </table>
                            <div class="separador"><p>Privilegios del Rol</p></div>
                    
                            <div class="bloqueB">
                        <%=fachada.cargarComportamientos() %>
                            </div>
                    
                        <br><br><p><input type="submit" value="Enviar"><p>
                
                    </form>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>

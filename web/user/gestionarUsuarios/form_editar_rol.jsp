<%-- 
    Document   : editarRol
    Created on : 31-jul-2012, 0:00:34
    Author     : CONNORS
--%>

<%@page import="com.sun.xml.internal.bind.v2.model.core.ID"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
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
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Consultar Roles - Hotel Quinta Avenida</title>
      <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        <div id="todo">
        <div class="cabecera">
      
        </div>
        <div class ="principal">
            <div class="menu" id="menu"> 
           
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    
                    <div class="separador">Seleccione un rol</div><br>
                    <form name="roles" action="#">
                        <%= fachada.getRoles() %><br>
                    <input type="button" onclick="sendRequest('getPrivilegiosRol.jsp')" value="Aceptar" name="toma" />
                    </form>
                </div>
                        <div id="bloqueB" class="bloqueB">
                            
                        </div>
            </div>
        </div>
        </div>
    </body>
</html>

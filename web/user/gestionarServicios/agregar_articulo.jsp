<%-- 
    Document   : cambiar_estado_habitacion
    Created on : 31-jul-2012, 23:40:21
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
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
        
        String idArticulo = request.getParameter("idArticulo");
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String msg = fachada.agregarCantidadArticulo(idArticulo, cantidad);
        
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Agregar Artículos - Hotel Quinta Avenida</title>
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
                    <div class="separador">Lista de Artículos</div>
                        <p><%=fachada.getListaArticulos() %></p>
                </div>
                <div class="bloqueB" id="bloqueB">
                    <div class="separador"><p>Información</p></div>
                        <p><%= msg %></p>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>

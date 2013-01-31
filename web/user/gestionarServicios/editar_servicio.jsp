<%-- 
    Document   : editar_servicio
    Created on : 06-ago-2012, 3:29:47
    Author     : CONNORS
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
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <title>Editar Servicios - Hotel Quinta Avenida</title>
      <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
        
<%  
        String nombre = request.getParameter("nombre");
        float cantidad = Float.parseFloat(request.getParameter("cantidad"));
        String nombreReal = request.getParameter("nombreReal");
        String msg ="";
        if(nombre.equals(nombreReal))
        msg = fachada.editarServicio(nombre, cantidad);
        else
        msg = fachada.editarServicio(nombre, nombreReal, cantidad);
        %>
        

        
        <div id="todo">  
        <div class="cabecera">
       
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
          
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Lista de Servicios</div><br>
                <%=fachada.getListaServicios()%>
                </div>
                <div class="bloqueB" id="bloqueB">
                   
                    <div class="separador">Información</div>
                    <br><%= msg %>
                </div>
            </div>
        </div>
       </div>
    </body>
</html>

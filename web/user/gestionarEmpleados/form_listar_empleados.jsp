<%-- 
    Document   : form_listar_empleados
    Created on : 05-ago-2012, 19:53:10
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
        <title>Lista de Empleados - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <style type="text/css" title="currentStyle">
			@import "../../css/demo_page.css";
			@import "../../css/demo_table.css";
        </style>
        <script type="text/javascript" src="../../js/ajax.js" ></script>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript" language="javascript" src="../../js/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="../../js/jquery.dataTables.js"></script>
        <script type="text/javascript">
			$(document).ready(function() {
				$('#example').dataTable({"bPaginate": false,"bInfo": false,"bFilter": false});
			} );
		</script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',18,5);">
        <div id="todo">  
        <div class="cabecera">
            
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
                
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Lista de Empleados</div><br>
                <%=fachada.getListaEmpleados()%>
                </div>
                <div class="bloqueB" id="bloqueB">
                    
                </div>
            </div>
        </div>
       </div>
    </body>
</html>

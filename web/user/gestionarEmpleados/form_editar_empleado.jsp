<%-- 
    Document   : form_editar_empleado
    Created on : 06-ago-2012, 20:39:07
    Author     : CONNORS
--%>

<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/ajax.js" ></script>

    </head>
    <body >
<%
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String funcion = request.getParameter("funcion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        String seguro = request.getParameter("seguro");  
%>
                <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
            
                <%
                ArrayList<String[]> menubt = (ArrayList<String[]>)sesion.getAttribute("modulos");
                String supermenu = "";
                
                supermenu+="<ul class= 'nav nav-pills'>";
                    supermenu+="<li class='active'>";
                        supermenu+="<a href='../../user/usuario/fichaUsuario.jsp'>Home</a>";
                    supermenu+= "</li>";
                    for(String[] modulo : menubt){
                        supermenu+="<li class='dropdown'>";
                            supermenu+="<a class='dropdown-toggle' id='menu"+modulo[0]+"' role='button' data-toggle='dropdown' data-target='#' href='#'>";
                                supermenu+=modulo[0];
                                supermenu+="<b class='caret'></b>";
                            supermenu+="</a>";
                        supermenu+="<ul class='dropdown-menu' role='menu' aria-labelledby='menu"+modulo[0]+"'>";
                        for(int i = 1; i<modulo.length;i++){
                            String[] sp = modulo[i].split("--");
                            supermenu+="<li><a href='"+sp[1]+"'>"+sp[0]+"</a></li>";
                        }
                        supermenu+= "</ul>";
                        supermenu+= "</li>";
                    }
                    
                supermenu+= "</ul>";
                %>
                <%=supermenu%>
                
            <div class="container" >
               <form class="form-horizontal" name="editaempleado" action="editar_empleado.jsp">
                   <fieldset>
                           <legend>Editar Empleado</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="inputCedula">Cédula o NIT: </label>
                               <div class="controls">
                                   <input type="text" id="inputCedula" name="cedula"  value="<%= cedula %>" required>
                                </div></div>
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombres: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre"  value="<%= nombre %>"required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputApellido">Apellidos: </label>
                                <div class="controls">
                                <input type="text" id="inputApellido" name="apellido" value="<%= apellidos %>" required>
                                </div></div>
                            

                                <div class="control-group">
                                    <label class="control-label" for="inputCorreo">E-mail: </label>
                                <div class="controls">
                                <input type="text" id="inputCorreo" name="correo" value="<%= correo %>" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputDireccion">Dirección: </label>
                                <div class="controls">
                                <input type="text" id="inputDireccion" name="direccion" value="<%= direccion %>" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputTelefono">Teléfono: </label>
                                <div class="controls">
                                <input type="text" id="inputTelefono" name="telefono" value="<%= telefono %>" required>
                                </div></div>
                                                    
                                <div class="control-group">
                                    <label class="control-label" for="inputNumero_ss">No. Seguridad Social: </label>
                                <div class="controls">
                                <input type="text" id="inputNumero_ss" name="seguro" value="<%= seguro %>" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputRol">Rol: </label>
                                <div class="controls">
                                <select name="funcion" id="inputRol">
                                    <%= fachada.getFuncionListaHTML() %>
                                    </select>
                                </div></div>
                             

                            
                            <div class="form-actions">
                            <button type="submit" class="btn" >Guardar cambios</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
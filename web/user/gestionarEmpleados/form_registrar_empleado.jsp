<%-- 
    Document   : form_registrar_empleado
    Created on : 05-ago-2012, 17:11:39
    Author     : jorge
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
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Registro de Empleados - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body >  
        <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
            
                <%
                ArrayList<String[]> menubt = (ArrayList<String[]>)sesion.getAttribute("modulos");
                String supermenu = "";
                
                supermenu+="<ul class= 'nav nav-pills'>";
                    supermenu+="<li class='active'>";
                        supermenu+="<a href='#'>Home</a>";
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
               <form class="form-horizontal" action="registrar_empleado.jsp" name="registro" >
                   <fieldset>
                           <legend>Registrar Empleado</legend>
                   
                               <div class="control-group">
                                   <label class="control-label" for ="inputCedula">Cédula o NIT: </label>
                               <div class="controls">
                                <input type="text" id="inputCedula" name="cedula" required>
                                </div></div>
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombres: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre"  required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputApellido">Apellidos: </label>
                                <div class="controls">
                                <input type="text" id="inputApellido" name="apellido" required>
                                </div></div>
                            
                               <div class="control-group">
                                    <label class="control-label" for="inputFechaNto">Fecha de Nto. (aaaa-mm-dd):</label>
                                <div class="controls">
                                <input type="text" id= "inputFechaNto" name="fechaNto" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputCorreo">E-mail: </label>
                                <div class="controls">
                                <input type="text" id="inputCorreo" name="correo" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputDireccion">Dirección: </label>
                                <div class="controls">
                                <input type="text" id="inputDireccion" name="direccion" required>
                                </div></div>
                            
                                <div class="control-group">
                                    <label class="control-label" for="inputTelefono">Teléfono: </label>
                                <div class="controls">
                                <input type="text" id="inputTelefono" name="telefono" required>
                                </div></div>
                                                    
                                <div class="control-group">
                                    <label class="control-label" for="inputNumero_ss">No. Seguridad Social: </label>
                                <div class="controls">
                                <input type="text" id="inputNumero_ss" name="numero_ss" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="inputRol">Rol: </label>
                                <div class="controls">
                                <select name="funcion" id="inputRol">
                                    <%= fachada.getFuncionListaHTML() %>
                                    </select>
                                </div></div>

                            
                            <div class="form-actions">
                            <button type="submit" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>

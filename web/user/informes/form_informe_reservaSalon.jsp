<%-- 
    Document   : form_informe_reservaSalon
    Created on : 21-ago-2012, 19:56:02
    Author     : jorge
--%>

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
        <link rel="stylesheet" href="../../css/login.css" title="estilo"> 
        <script type="text/javascript" src="../../js/menu.js"></script>
        <title>Informe de reserva de Salones por mes</title>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    
    
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <div id="todo">
            <div class="cabecera">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            <div class="principal">
                <div class="menu" id="menu">
                </div>
                <div class="contenido">
                    <div class="bloqueC">
                        <div class="separador">Informe mensual de reservas</div>
                        <form action="informe_reservaSalon.jsp" name="registro">
                            <table>
                                <br><br>
                            <tr>
                                <td><label>Seleccione mes: </label></td>
                                <td><select name="mes">
                                        <option value="1">Enero</option>
                                        <option value="2">Febrero</option>
                                        <option value="3">Marzo</option>
                                        <option value="4">Abril</option>
                                        <option value="5">Mayo</option>
                                        <option value="6">Junio</option>
                                        <option value="7">Julio</option>
                                        <option value="8">Agosto</option>
                                        <option value="9">Septiembre</option>
                                        <option value="10">Octubre</option>
                                        <option value="11">Noviembre</option>
                                        <option value ="12">Diciembre</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td><label>Seleccione Año: </label></td>
                                <td><select name="agno">
                                        <option>2011</option>
                                        <option selected>2012</option>
                                    </select></td>
                            </tr>
                        </table>
                            <br>
                            <input type="submit" value="Generar Tabla">
                            <br><br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
</html>

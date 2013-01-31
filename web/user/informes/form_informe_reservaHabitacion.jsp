<%-- 
    Document   : form_informe_reservaHabitacion
    Created on : 21-ago-2012, 19:05:02
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
        <title>Informe de reserva de habitaciones por mes</title>
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
                        <form action="informe_reservaHabitacion.jsp" name="registro">
                            <table>
                                <br><br>
                            <tr>
                                <td><label>Seleccione mes: </label></td>
                                <td><select name="mes">
                                        <option value="01">Enero</option>
                                        <option value="02">Febrero</option>
                                        <option value="03">Marzo</option>
                                        <option value="04">Abril</option>
                                        <option value="05">Mayo</option>
                                        <option value="06">Junio</option>
                                        <option value="07">Julio</option>
                                        <option value="08">Agosto</option>
                                        <option value="09">Septiembre</option>
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

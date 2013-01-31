<%-- 
    Document   : form_listar_salones
    Created on : 05-ago-2012, 15:24:37
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<%@page session='true'%>
<html>
    <head>
        <% 
        
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu"); 
        String fecha= hallarFecha(request.getParameter("fecha"));
        
        %>
        <script type="text/javascript" src="../js/ajax.js" ></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <title>JSP Page</title>
        <script type="text/javascript" src="../../js/menu.js"></script>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
    </head>
    <body onload="menu1.escribeacordeon('menu',22,5);">
        <%!
        public String hallarFecha(String x){
        System.err.print(x);
        String fechas[]= x.split(" ");
        return fechas[2]+"-"+hallarMes(fechas[1])+"-"+fechas[0];  
        }    
    %>
    
    <%!
    public int hallarMes(String mes){
                
        if(mes.equals("Enero")) return 1;
        if(mes.equals("Febrero")) return 2;
        if(mes.equals("Marzo")) return 3;
        if(mes.equals("Abril")) return 4;
        if(mes.equals("Mayo")) return 5;
        if(mes.equals("Junio")) return 6;
        if(mes.equals("Julio")) return 7;
        if(mes.equals("Agosto")) return 8;
        if(mes.equals("Septiembre")) return 9;
        if(mes.equals("Octubre")) return 10;
        if(mes.equals("Noviembre")) return 11;
        if(mes.equals("Diciembre")) return 12;
        return 0;
               }
    %>
        
        <div id="todo">  
        <div class="cabecera">
       
        </div>
        <div class ="´principal">
            <div class="menu" id="menu"> 
           
            </div>
            
            <div class="contenido">
                <div class="bloqueA">
                    <div class="separador">Reservas de habitaciones</div><br>
                    <%=fachada.getReservaByFecha(fecha)%>
                </div>
                <div class="bloqueB" id="bloqueB">
                    
                </div>
            </div>
        </div>
       </div>
    </body>
</html>



<%-- 
    Document   : guerdarReservas
    Created on : 05-ago-2012, 15:38:28
    Author     : Carlos
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<!DOCTYPE html>
<%@page session='true'%>
<html>
        <%
        
        
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        
        String idEmpleado=id;
        String idSalon=request.getParameter("salon");
        String fechaReserva=hallarFecha(request.getParameter("fecha"));
        java.util.Date fechaActual=new Date();
        int abono=Integer.parseInt(request.getParameter("abono"));
        String idCliente=request.getParameter("cliente");
        int hora=Integer.parseInt(request.getParameter("hora"));
        String msj = (String)sesion.getAttribute("htmlmenu"); 
        int duracion=Integer.parseInt(request.getParameter("duracion"));
        String descripcion= request.getParameter("descripion");
        String z="";
        
        
                z=fachada.guardarReserva(idSalon, fechaReserva, fechaActual, 
                        idEmpleado, idCliente, abono, descripcion, duracion, hora);
        
        
        
            
        %>
    <head>
         <link rel="stylesheet" href="../../css/login.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <div class="separador"><p>Informacion</p></div><br>
                    <%=z%>
                </div>
            </div>
        </div>
       </div>
    
    </body>
</html>

<%--
    Created on : 05-ago-2012, 15:38:28
    Author     : Carlos
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session='true'%>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
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
        
        
        String idHabitacion=request.getParameter("habitacion");
        String fechaReserva=hallarFecha(request.getParameter("fecha"));
        java.util.Date fechaActual=new Date();
        String idCliente=request.getParameter("cliente");
        String idEmpleado=id;
        String descripcion= request.getParameter("descripcion");
        String z="";
        
        
                z=fachada.guardarReservaHabitacion(idHabitacion, fechaReserva, fechaActual, 
                        idCliente, descripcion, idEmpleado);
            
        
            
        %>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservar habitacion</title>
         <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>    
    </head>
    <body>
        
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
        
        
        
        
            <div class="page-header">
                <h1>Hotel Quinta Avenida</h1>
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
        <div class="container" >        
        <%=supermenu%>
                
            <div class="container" >
               <h2><%=z%></h2>
            </div>
        </div>
        
    </body>
</html>

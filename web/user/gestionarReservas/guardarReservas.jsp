<%-- 
    Document   : guerdarReservas
    Created on : 05-ago-2012, 15:38:28
    Author     : Carlos
--%>
<%@page import="java.util.ArrayList"%>
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
        String msj = (String)sesion.getAttribute("htmlmenu"); 

        String idEmpleado=id;
        String idSalon=request.getParameter("salon");
        String fechaReserva=hallarFecha(request.getParameter("text"));
        java.util.Date fechaActual=new Date();
        int abono=Integer.parseInt(request.getParameter("abono"));
        String idCliente=request.getParameter("cliente");
        int hora=Integer.parseInt(request.getParameter("hora"));
        int duracion=Integer.parseInt(request.getParameter("duracion"));
        String descripcion= request.getParameter("descripcion");
        String z="";
        
        
                z=fachada.guardarReserva(idSalon, fechaReserva, fechaActual, 
                        idEmpleado, idCliente, abono, descripcion, duracion, hora);
        
        
        
            
        %>
    <head>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guargar reservas</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>   
    </head>
    <body>
       
        
        <%!
        public String hallarFecha(String x){
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
        <div class="container" >
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
                <%=supermenu%>
                
            <div class="container" >
               <h2><%=z%></h2>
            </div>
        </div>

    
    </body>
</html>

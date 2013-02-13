<%@page import="java.util.ArrayList"%>
<html>
<head>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        

        <title>Crear Habitaciones - Hotel Quinta Avenida</title>
        <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css" type="text/css">
        <script type="text/javascript" src="../../js/jquery-1.7.2.js"></script> 
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../js/ajax.js" ></script>
</head>
<body>

<div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            <%
            
        HttpSession sesion=request.getSession(); 
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
            
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
          
        <%
        
        String piso = request.getParameter("piso");
        String hab = request.getParameter("habitacion");
        String tipo = request.getParameter("tipo_habitacion");
        
        if(fachada.crear_habitacion(piso,hab,tipo))
            out.println("<h1>Habitación creada con éxito</h1>");//se pudo crear la habitacion
        else{ 
            out.println("<h1>No se pudo crear la habitación</h1>");//no se pudo crear
        }
        %>

            </div>
        
</body>
</html>
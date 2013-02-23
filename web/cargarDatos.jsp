<html>
    <head>
		<meta charset="UTF-8">
		
        <title> Hotel Quinta Avenida </title>
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0;" />
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
                <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
                <script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
    </head>
    
    <body>
         <jsp:useBean id="fachada" scope="page" class="negocio.FachadaMovil" />
         <%
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        if(fachada.validarUsuario(usuario,password)){

            HttpSession sesion = request.getSession();
            sesion.setAttribute("id", usuario);
        }
        else
        {
            response.sendRedirect("inicio.jsp");
        }    
        %>
        
         <div data-role="page" id="inicio2">
            <div data-role="header">
                <h1> Hotel Quinta Avenida</h1>
                <div data-role="navbar" data-iconpos="bottom" data-theme="b">
		<ul>
			<li><a href="#inicio2" data-icon="grid" class="ui-btn-active ui-state-persist">Inicio</a></li>
			<li><a href="#misreservas" data-icon="info" >Mis Reservas</a></li>
			<li><a href="#hospedajes" data-icon="search">Mis Hospedajes</a></li>
		</ul>
                </div>
            </div>
            <div data-role="content">
			<%=fachada.getDatosUsuario(usuario)%>	
            </div>
            <footer data-role="footer" >
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>	
            </div>
         
         
         
        
        
         
         
         <div data-role="page" id="misreservas">
            <div data-role="header">
                <h1> Hotel Quinta Avenida</h1>
                <div data-role="navbar" data-iconpos="bottom" data-theme="b">
		<ul>
			<li><a href="#inicio2" data-icon="grid">Inicio</a></li>
			<li><a href="#misreservas" data-icon="info" class="ui-btn-active ui-state-persist">Mis Reservas</a></li>
			<li><a href="#hospedajes" data-icon="search">Mis Hospedajes</a></li>
		</ul>
                </div>
            </div>
            <div data-role="content">
                <div data-role="collapsible" data-theme="b" data-content-theme="b">
                    <h4>Reservas de Salones</h4>
                     <p><%=fachada.getReservasMovil(usuario)%></p>
                </div>
		<div data-role="collapsible" data-theme="b" data-content-theme="b">
                    <h4>Reservas de Habitaciones</h4>
                     <p><%=fachada.getReservasHabitaciones(usuario)%></p>
                </div>		
            </div>
            <footer data-role="footer" >
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>	
            </div>
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <div data-role="page" id="hospedajes">
            <div data-role="header">
                <h1> Hotel Quinta Avenida</h1>
                <div data-role="navbar" data-iconpos="bottom" data-theme="b">
		<ul>
			<li><a href="#inicio" data-icon="grid">Inicio</a></li>
			<li><a href="#misreservas" data-icon="info">Mis Reservas</a></li>
			<li><a href="#hospedajes" data-icon="search" class="ui-btn-active ui-state-persist">Mis Hospedajes</a></li>
		</ul>
                </div>
            </div>
            <div data-role="content">
				
            </div>
            <footer data-role="footer" >
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>	
            </div>
        
    </body>
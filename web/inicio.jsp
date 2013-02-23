
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		
        <title> Hotel Quinta Avenida </title>
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0;" />
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
                <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
                <script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>

		<script type="text/javascript"
			src="https://maps.google.com/maps/api/js?sensor=true">
		</script>
		
		<script type="text/javascript">
			var latlng=new google.maps.LatLng(7.887, -72.505);
			var actual=new google.maps.LatLng(7.880, -72.500);
			var directionDisplay;
      		var directionsService = new google.maps.DirectionsService();
      		var map;

			function initialize() {
			 directionsDisplay = new google.maps.DirectionsRenderer();	
			var myOptions = {
			zoom: 15,
			center: latlng,
			mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

			var marker = new google.maps.Marker({
     		position: latlng, 
      		map: map, 
     		draggable:true,
     		animation: google.maps.Animation.DROP,
      		title:'Hotel Quinta Avenida'
  			});

  			

    			
    			var market = new google.maps.Marker({
     			position: actual, 
      			map: map, 
     			draggable:true,
     			animation: google.maps.Animation.DROP,
      			title:'Estoy aca'
      			//market.setMap(map);
  			});
    		directionsDisplay.setMap(map);	
    	}
  // Try Google Gears Geolocation
  			
  			function calcRoute() {
  				var selectedMode = "WALKING";
  				var request = {
      				origin: latlng,
      				destination: actual,
      // Note that Javascript allows us to access the constant
      // using square brackets and a string value as its
      // "property."
     				 travelMode: google.maps.TravelMode[selectedMode]
 					 };
  						directionsService.route(request, function(response, status) {
    					if (status == google.maps.DirectionsStatus.OK) {
      					directionsDisplay.setDirections(response);
    }
  });
}
  			
  			function toggleBounce(){

  			if (marker.getAnimation() != null) {
    			marker.setAnimation(null);
 			 } 
 			 else {
    		marker.setAnimation(google.maps.Animation.BOUNCE);
  			}

  		};

		</script>
        

		
    </head>
	
    <body onload="initialize(); calcRoute()">
        <jsp:useBean id="fachada" scope="page" class="negocio.FachadaMovil" />
        <div data-role="page" id="inicio">
            <div data-role="header">
                <h1> Hotel Quinta Avenida</h1>				
            </div>
            <div data-role="content">
				<p align="center"><img src="js/Hotel.jpg"  style="height:100%; width:100%"/></p>
			
				<ul>
					<li><a href="#habitaciones" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b'>Habitaciones</a></li>
					<li><a href="#servicios" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b'>Servicios</a></li>
					<li><a href="#salones" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b'>Salones</a></li>
					<li><a href="#loguin" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b'>Mi Cuenta</a></li>
					<li><a href="#reservas" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b'>Reservas</a></li>
					<li><a href="#contactenos" onClick="calcRoute()" data-transition="slidedown" data-role="button" 
						data-icon="arrow-r" data-iconpos="right" data-theme='b' >Contactenos</a></li>		
					
				</ul>
            
            </div>
            <footer data-role="footer" >
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>	
            </div>
        
		
		
		
		<div data-role="page" id="habitaciones">
			<div data-role="header">
                            <a href="#inicio" data-icon="home">Inicio</a>
                            <h1>Habitaciones</h1>
			</div>
                    
			<div data-role="content">
			
                            <%=fachada.listaHabitaciones()%>
			
			</div>
			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
		
		
		
		<div data-role="page" id="servicios">
			<div data-role="header">
                            <a href="#inicio" data-icon="home">Inicio</a>
				<h1>Servicios</h1>
			</div>
			<div data-role="content">
                            <div data-role="collapsible" data-collapsed-icon="arrow-r"  data-expanded-icon="arrow-d" data-theme="b" data-content-theme="b">
                                <h3>Salones de Eventos</h3>
                                <p>En el Hotel Quinta Avenida encontraras una variedad de salones para que puedas realizar
                                    todas tur reuniones sociales, además estan modernamente amoblados para cualquier tipo
                                    de Actividad que quieras realizar en él.</p>
                            </div>
                            <div data-role="collapsible" data-collapsed-icon="arrow-r"  data-expanded-icon="arrow-d" data-theme="b" data-content-theme="b">
                                <h3>Piscina</h3>
                                <p>El Hotel Quinta Avenida cuenta con dos piscinas, para que disfrutes tu estadia
                                con un rato de esparcimiento y relajación, además cuenta con clases de natación
                                y diversas actividades ludicas en las cuales te puedes divertir en familia</p>
                            </div>
                            <div data-role="collapsible" data-collapsed-icon="arrow-r"  data-expanded-icon="arrow-d" data-theme="b" data-content-theme="b">
                                <h3>Restaurante</h3>
                                <p>El Hotel Quinta Avenida te ofrece las mejores comidas, disfruta los mejores platos
                                gastronomicos de la región y de cuaquier parte del mundo, preparado por los mejores chef de la región.</p>
                            </div>
                            <div data-role="collapsible" data-collapsed-icon="arrow-r"  data-expanded-icon="arrow-d" data-theme="b" data-content-theme="b">
                                <h3>Gimnacio</h3>
                                <p>En el Hotel Quinta Avenida, también queremos cuidar tu salud. Contamos on un gimnacio totalmente
                                    equipado para que no dejes de lado tus ejercicios, ademas de instructores bien capacitador
                                    dispuestos a birndarte un acompañamiento. Este servicio es Gratis con el hospedaje, y con cobro diario
                                    , semanal o anual para cualquier persona.</p>
                            </div>
                            <div data-role="collapsible" data-collapsed-icon="arrow-r"  data-expanded-icon="arrow-d" data-theme="b" data-content-theme="b">
                                <h3>Servicios en las Habitaciones</h3>
                                <p>El Hotel Quinta Avenida te brinda todos los servicios basicos que necesitas en tu día a día,
                                Televisión por cable, Wifi, Sala con internet, Aire acondisionado y muchas mas comidades para que 
                                 disfrutes tus días de estadia</p>
                            </div>
			
			</div>
			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
		
		
		
		
		<div data-role="page" id="loguin">
			<div data-role="header">
                                <a href="#inicio" data-icon="home">Inicio</a>
				<h1>Iniciar Sesion</h1>
			</div>
			<div data-role="content">
				<form id="formlogin" action="cargarDatos.jsp" method="GET" data-theme="b">
					<div data-role="fieldcontain">
					<label for="usuario"> Usuario </label>
					<input type="text" id="usuario" data-icon="home" name="usuario"  placeholder="  Tu usuario"/><br><br>
					<label for="pass"> Contraseña </label>
					<input type="password" id="pass" data-icon="home" name="password"  placeholder="  Tu Contraseña"/>
                                        <br><br>
					<input style="text-align:center; " type="submit" data-transition="slidedown" data-role="button" data-icon="check" data-iconpos="right" value="Iniciar Sesión" data-theme='b'/>
					</div>
				</form>
			</div>
			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
		
		
		
		
		<div data-role="page" id="reservas">
			<div data-role="header">
                                <a href="#inicio" data-icon="home">inicio</a>
				<h1>Reservas</h1>
			</div>
                    
			<div data-role="content">
                           <form id="formlogin" action="enviarCorreo.jsp" method="GET" data-theme="b">
				<label>Seleccione la Fecha:</label>
				<fieldset data-role="controlgroup" data-type="horizontal">
					<select name="select-choice-day" id="select-choice-day">
						<option>Día</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">8</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
						
						
                                                
					</select>
					
					<select name="select-choice-month" id="select-choice-month">
						<option>Mes</option>
							<option value="1">Enero </option>
                                                        <option value="2"> Febrero </option>
                                                        <option value="3"> Marzo </option>
                                                        <option value="4"> Abril </option>
                                                        <option value="5"> Mayo </option>
                                                        <option value="6"> Junio </option>
                                                        <option value="7"> Julio</option>
                                                        <option value="8"> Agosto</option>
                                                        <option value="9"> Septiembre</option>
                                                        <option value="10"> Octubre</option>
                                                        <option value="11"> Noviembre</option>
                                                        <option value="12"> Diciembre</option>
					</select>
					
					<select name="select-choice-year" id="select-choice-year">
						<option>Año</option>
						<option value="2013">2013</option>
                                                <option value="2014">2014</option>
					</select>
                                        
				</fieldset><br>
                                
                                <%=fachada.listarOpcionSal()%><br>
                                
                                <div data-role="fieldcontain">
                                    <label for="name">Numero de Telefono:</label>
                                    <input type="text" name="telefono" id="name" value="" placeholder="  Tu Nº de Celular" />
                                </div>	
                                <input style="text-align:center; " type="submit" data-transition="slidedown" 
                                       data-role="button" data-icon="check" data-iconpos="right" value="Enviar Solicitud" data-theme='b'/>
                           </form>
			</div>
			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
		
		
		
		<div data-role="page" id="contactenos" >
			<div data-role="header">
                            <a href="#inicio" data-icon="home">Inicio</a>	
                            <h1>Contactenos</h1>
                                
			</div>
			
			<div data-role="content" >
			
						<figure id="map_canvas" style="height:300px; width:300px"></figure>
					
			</div>

			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
		
		
		
		<div data-role="page" id="salones">
			<div data-role="header">
                            <a href="#inicio" data-icon="home">Inicio</a>
                            <h1>Salones</h1>
			</div>
			<div data-role="content">
			<%=fachada.listaSalones()%>
			
			</div>
			
			<footer data-role="footer">
				<h3 style="font-size: 12px"> UFPS </h3>
				<h4 style="font-size: 12px" > 2012 - Derechos Reservados </h4>
			</footer>
		</div>
    </body>
	
</html>
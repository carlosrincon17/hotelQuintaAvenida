function ajaxobj() {
	try {
		_ajaxobj = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			_ajaxobj = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			_ajaxobj = false;
		}
	}
	if (!_ajaxobj && typeof XMLHttpRequest!='undefined') {
		_ajaxobj = new XMLHttpRequest();
	}
	return _ajaxobj;
}

function verReservas(url){
    
    http = ajaxobj();
    
    document.getElementById("bloqueB").innerHTML = url.name;
    
    var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
    var modurl = url.name+"&rand="+myRand;
    
    http.open("GET", modurl , true);
    
    http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;

        document.getElementById("bloqueB").innerHTML = "<div class='separador'><p>Información</p></div><p>"+response+"</p>";
	}
    
	else
		document.getElementById("bloqueB").innerHTML = "cargando...";
    };
    
    http.send(null);
    
}

function cambiarEstado(algo){
    
 var titulo=algo.title;
 if(confirm('¿Seguro que desea '+titulo+'?')){
 var url = algo.name;
 var http = ajaxobj();
     var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
    var modurl = url+"&rand="+myRand;
    
    http.open("GET", modurl , true);
    
    http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;
        document.getElementById("bloqueB").innerHTML = " ";
        alert(response);
	}
    
	else
		document.getElementById("bloqueB").innerHTML = "cargando...";
    };
    http.send(null);
    }
 
}
function cambiarHabitacion(link){
    var url = link.name;
    var http = ajaxobj();
    var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
    var modurl = url+"&rand="+myRand;
    
    http.open("GET", modurl , true);
    
    http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;
        document.getElementById("bloqueB").innerHTML = response;
	}
    
	else
		document.getElementById("bloqueB").innerHTML = "cargando...";
    };
    http.send(null);
}

function actualizarEmpleado(){
    
    var http = ajaxobj();
    
    var cedula = document.editaempleado.cedula.value;
    var funcion = document.editaempleado.funcion.selectedIndex;
    var idfuncion = document.editaempleado.funcion.options[funcion].value;
    var telefono = document.editaempleado.telefono.value;
    var correo = document.editaempleado.correo.value;
    var direccion = document.editaempleado.direccion.value;
    var seguro = document.editaempleado.seguro.value;
    var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
    var modurl = "editar_empleado.jsp"+"?rand="+myRand+"&cedula="+cedula+"&funcion="+idfuncion+"&telefono="+telefono+"&correo="+correo+"&direccion="+direccion+"&seguro="+seguro;
    
    http.open("GET", modurl , true);
    
    http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;

        document.getElementById("bloqueB").innerHTML = "<div class='separador'><p>Información</p></div><p>"+response+"</p>";
	}
    
	else
		document.getElementById("bloqueB").innerHTML = "<img src='../imagen/loading.gif' />'";
    };
    http.send(null);
    
}

function crearHabitacion(){
    
    var http = ajaxobj();
    var piso = document.crear.pisos.selectedIndex;
    var numpiso = document.crear.pisos.options[piso].text;

    var habitaciones = document.crear.habitaciones.selectedIndex;
    var numhabitacion = document.crear.habitaciones.options[habitaciones].text;
    
    var tipo = document.crear.tipos.selectedIndex;
    var numtipo = document.crear.tipos.options[tipo].text;
    
    var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
    var modurl = "crear_habitacion.jsp"+"?rand="+myRand+"&piso="+numpiso+"&habitacion="+numhabitacion+"&tipo_habitacion="+numtipo;
    
    http.open("GET", modurl , true);
    
    http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;

        document.getElementById("bloqueB").innerHTML = "<div class='separador'><p>Información</p></div><p>"+response+"</p>";
	}
    
	else
		document.getElementById("bloqueB").innerHTML = "cargando...";
    };
    http.send(null);
    
}

function sendRequest(url)
{

var http = ajaxobj();
var indice = document.roles.misroles.selectedIndex;
var rol = document.roles.misroles.options[indice].text;

var myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
var modurl = url+"?rand="+myRand+"&rol="+rol;

http.open("GET", modurl , true);

http.onreadystatechange = function(){
	if(http.readyState == 4 && http.status == 200){
	var response = http.responseText;
	document.getElementById("bloqueB").innerHTML = response;
	}
	else
		document.getElementById("bloqueB").innerHTML = "cargando...";
};
http.send(null);
}

function getEmpleado(){
	
	var cedula = document.getElementById("documento");
	var myurl = 'consultar_empleado.jsp';
	myRand = parseInt(Math.random()*99999999999); // Asegura que la página no se va a buscar en caché para que interactue directamente con el servidor
	var modurl = myurl+"?rand="+myRand+"&documento="+cedula;
	http.open("GET", modurl, true); // Acá se crea la petición al servidor
	http.onreadystatechange = useHttpResponse; // Acá se indica la función de respuesta, 
	http.send=(null); // Se envía la petición al servidor
}

function godown() {
   $('#final').click(function () {
       $('html, body').animate({
           scrollTop: $(document).height()
       },
       1500);
       return false;
   });
   } 

// Creo la clase Menu
function Menu(){
	//Esta propiedad me dice cual es el �tem actual abierto.
	this.actual;
	//Esta propiedad me dice si un �tem est� abierto o no.
	this.estado = false;
	//Esta propiead almacena el total de �tems que tiene el men�.
	this.total;
	//Metodo que se encarga de escribir los �tems y sub �tems del menu, asegur�ndose de dejar a todos los �tems sin desplegar.
	this.principal;
	
	this.stringfunc = "\" onClick=\"menu1.despliega(";
														
	this.altosfinales = new Array();
	
	this.velocidad;
	
	this.escribe = function(contenedor,alto,velocidad){
		
		this.principal = document.getElementById(contenedor);
		this.total = this.items.length;
		this.velocidad = velocidad;
		
		for(var i=0;i<this.total;i++){
			this.principal.innerHTML+= "<div id=\"" + this.items[i][0] + "\"><a href=\"" + this.items[i][1] + this.stringfunc + i + ");\" alt=\"" + this.items[i][2] + "\" target=\"" + this.items[i][3]  + "\">" + this.items[i][2] + "</a></div>";
	
			this.principal.innerHTML+= "<ul id=\"sub" + this.items[i][0] + "\">";
			
			for(var k=0;k<this.subitems[i].length;k++){
					document.getElementById("sub" + this.items[i][0]).innerHTML+= "<li><a href=\"" + this.subitems[i][k][1] + "\" alt=\"" + this.subitems[i][k][0] + "\" target=\"" + this.subitems[i][k][3]  + "\">" + this.subitems[i][k][2] + "</a></li>";
			}
			this.principal.innerHTML+= "</ul>"
			
			document.getElementById("sub" + this.items[i][0]).style.height = "0px";
			
			this.altosfinales[i] = this.subitems[i].length * 19;
			
		}

	}

	this.despliega = function(itemdiv){
	
		for(var i=0;i<this.total;i++){
			var principal = document.getElementById("subitem-" + i);
			if(itemdiv == i){
				if(itemdiv == this.actual && this.estado == false){
					principal.style.height = "0px";
					this.estado = true;
				}else{
					principal.style.height = this.altosfinales[i] + "px";
					this.estado = false;
				}
			}else{
				principal.style.height = "0px";
			}
		}
	this.actual = itemdiv;
	}

}


function Desplegable(msj){
	
	this.stringfunc = "\" onClick=\"menu1.despliegaacor(";
														
	this.alturaparciala = 0;
        
        var texto = msj;
        var titulos = texto.split('*');
	this.items = new Array();
	this.subitems = new Array();
	for( i = 0; i < titulos.length - 1; i ++){
		this.items[i]= titulos[i].split(',');
	}
	var subtitulos = titulos[titulos.length - 1];
	var subs = subtitulos.split('&');
	for(var j = 0; j < subs.length -1 ; j++){
	
		var sub = subs[j].split('#');
		var array = new Array();
		for(var k = 0; k < sub.length -1 ; k++){
			array[k] = sub[k].split(',');
		}
		this.subitems[j]= array;
    }
        
	this.ultimosubmenu;
	
	this.estadoclick = true;

	this.escribeacordeon = function(contenedor,alto,velocidad){
		this.escribe(contenedor,alto,velocidad);
	}
	

	this.despliegaacor = function(itemdiv){
		
		if(this.estadoclick == true){
		
			var raiz = this;
			var principalactual;
			var sigueabriendo;
			
				function abre(principal,est){
						
						raiz.estado = false;
						
						if(est){
							principalactual = principal;
						}
						
						raiz.alturaparciala = raiz.alturaparciala + raiz.velocidad;
						
						if(raiz.alturaparciala >= principalactual.alturaparcialc){
							raiz.ultimosubmenu = principalactual;
							clearTimeout(inter);
							raiz.alturaparciala = 0;
							raiz.estadoclick = true;
		
						}else{
							principalactual.style.height = raiz.alturaparciala + "px";
							var inter = setTimeout(abre,10);
						}
	
				}
				
				function cierra(principal,est,sigue){
					
					if(est){
						principalactual = principal;
						sigueabriendo = sigue;
					}
					
					principalactual.alturaparcialc = principalactual.alturaparcialc - raiz.velocidad;
					
					if(principalactual.alturaparcialc <= 0){
						clearTimeout(inter);
						principalactual.style.height = "0px";
						if(sigueabriendo){
							abre(sigueabriendo,true);
							raiz.estadoclick = false;
						}else{
							raiz.ultimosubmenu = 0;
							raiz.alturaparciala = 0;
							raiz.estadoclick = true;
						}
					}else{
						principalactual.style.height = principalactual.alturaparcialc + "px";
						var inter = setTimeout(cierra,10);
					}
					
				}

			
			
			for(var i=0;i<this.total;i++){
				
				var principal = document.getElementById("subitem-" + i);
				
				principal.alturaparcialc = this.altosfinales[i];
				if(principal.alturaparcialc > 0){
					if(itemdiv == i){
						if(itemdiv == this.actual && this.estado == false){
							cierra(principal,true);
							this.estado = true;
							this.ultimosubmenu = undefined;
						}else{
							if(this.ultimosubmenu){
								cierra(this.ultimosubmenu,true,principal);
							}else{
								abre(principal,true);
								
							}
						}
	
					}
				}else{
					if(itemdiv == i){
						cierra(this.ultimosubmenu,true,false);
					}
				}
										
			}
			
		this.actual = itemdiv;
		
		}
		
		if(this.total == 0){
			this.estadoclick = true;
		}
	}
		
}

Desplegable.prototype= new Menu();

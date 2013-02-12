<html>
<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />     
<%@page import="java.util.ArrayList"%>
<% 
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        
        String idArticulo = request.getParameter("articulo");
        String nombre = request.getParameter("nombre");
        
        %>
        
                <div class="container" >
            <div class="page-header">
                <h1>Hotel Quinta Avenida<small> aqui deberia ir un mensaje</small></h1>
            </div>
            
                <%
                ArrayList<String[]> menubt = (ArrayList<String[]>)sesion.getAttribute("modulos");
                String supermenu = "";
                
                supermenu+="<ul class= 'nav nav-pills'>";
                    supermenu+="<li class='active'>";
                        supermenu+="<a href='#'>Home</a>";
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
               <form class="form-horizontal" action="agregar_articulo.jsp" name="form">
                   <fieldset>
                           <legend>Agregar nuevo articulo</legend>
                   
                               
                        
                                <div class="control-group">
                                    <label class="control-label" for="inputNombre">Nombre: </label>
                                <div class="controls">
                                <input type="text" id="inputNombre" name="nombre" value="<%= nombre %>" required>
                                </div></div>

                                <div class="control-group">
                                    <label class="control-label" for="cantidad">Cantidad a añadir: </label>
                                <div class="controls">
                                <input type="text" id="cantidad" name="cantidad" required>
                                </div></div>

                                <input type="hidden" name="idArticulo" value="<%= idArticulo %>">
                            
                            
                            <div class="form-actions">
                            <button type="submit" name="guardar" class="btn" >Registrar</button>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </html>    
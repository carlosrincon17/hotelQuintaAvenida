<jsp:useBean id="fachada" scope="page" class="negocio.Hotel_facade" />
        <%
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu");
        String hospedaje = request.getParameter("hospedaje");
        String hospedaje2="'"+hospedaje+"'";
 
%>

<h2>Registrar Servicio en el Hospedaje</h2>

<form class="form-horizontal" action="agregarAHospedaje.jsp">
  <div class="control-group">
        <label class="control-label" for="estado">Servicio:  </label>
  <div class="controls">
            <%=fachada.getListaServiciosOption()%>
  </div>
  </div>
  <div class="control-group">
        <label class="control-label" for="estado">Cantidad </label>
  <div class="controls">
      <input type="text" name="cantidad" id="text" />
  </div>
  </div>
  <div class="control-group">
        
  <div class="controls">
      <input type="hidden" name="hospedaje" value=<%=hospedaje2%>/>
     <button type="submit" class="btn" >Registrar</button>
  
  </div> 
  
  </div>
      
</form>

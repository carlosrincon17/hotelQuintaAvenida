<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        
<%
        HttpSession sesion=request.getSession();
                
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }

        String habitacion = request.getParameter("habitacion");
%>
                    <div class="separador"><p>Editar una habitación</p></div><br>
                    <form action="editar_habitacion.jsp">
                        <p>Habitacion: <input type="text" name="habitacion" value="<%=habitacion%>"  required/></p>
                        <p>Tipo: <select name="tipo">
                        <%=fachada.getTipoHabitacionListaHTML(habitacion)%>
                         </select></p>
                        <input type="submit" value="Guardar cambios" name="guardar" /><br><br>
                    </form>


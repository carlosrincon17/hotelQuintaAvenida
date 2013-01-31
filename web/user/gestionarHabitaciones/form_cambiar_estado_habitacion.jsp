<jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
        <%
        
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {

            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        
        String habitacion = request.getParameter("habitacion");
        %>
                    <div class="separador"><p>Editar una habitación</p></div><br>
                        <form action="cambiar_estado_habitacion.jsp">
                            <p>Número de Habitacion: <input type="text" name="habitacion" value="<%=habitacion%>" required/></p>
                                <p><select name="estado">
                                    <%=fachada.getEstadoHabitacionListaHTML(habitacion)%>
                                    </select></p>
                            <input type="submit" value="Guardar cambios" name="guardar" /><br><br>
                        </form>
    </body>
</html>

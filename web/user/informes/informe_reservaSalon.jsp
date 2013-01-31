<%-- 
    Document   : informe_reservaSalon
    Created on : 21-ago-2012, 19:56:24
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session='true'%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" scope="session" class="negocio.Hotel_facade" />
<%  
        HttpSession sesion=request.getSession(); 
        
        if (sesion.getAttribute("rol") == null) {
            response.sendRedirect("../../iniciarSesion.jsp?error=Es obligatorio identificarse");
        }
        String rol = (String)sesion.getAttribute("rol");
        String id = (String)sesion.getAttribute("id");
        String msj = (String)sesion.getAttribute("htmlmenu");
        
        String mes = request.getParameter("mes");
        String agno= request.getParameter("agno");
                        
        int[] mostrar = fachada.getEstadisticasReservaSalonMes(mes, agno);
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/login.css" title="estilo"> 
        <script type="text/javascript" src="../../js/menu.js"></script>
        <title>Informe de reserva de Salones por mes</title>
        <script type="text/javascript">
            var menu1 = new Desplegable(<%= "'"+msj+"'" %>);
        </script>
        
         <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Reservas');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['En espera', <%= mostrar[0] %>],
          ['Activas', <%= mostrar[1] %>],
          ['Canceladas', <%= mostrar[2] %> ],
        ]);

        // Set chart options
        var options = {'title':'Informe de reservas mensual',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

    </head>
    
    <body onload="menu1.escribeacordeon('menu',22,5);">
        
        <div id="todo">
            <div class="cabecera">
                <h1>Hotel Quinta Avenida</h1>
            </div>
            <div class="principal">
                <div class="menu" id="menu">
                </div>
                <div class="contenido">
                    <div class="bloqueC">
                        <div class="separador">Informe de reservas de Salones</div>
                        
                        <div id="chart_div"></div>
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
    
</html>

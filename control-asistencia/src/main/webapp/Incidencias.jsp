<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "org.tesoreria.Incidencias" %>
    <%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/incidencias.css">
  <link rel="stylesheet" href="css/format.css">
  <title>Justificación de Incidencias</title>
 <%/* 
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");*/
  %>
</head>

<body>
<%SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");%>
  <jsp:include page="nav-admin.jsp"></jsp:include>
  <% 
  //ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
  ArrayList<Incidencias> list = (ArrayList<Incidencias>) request.getAttribute("listain"); %>>
  
  <h1>Aviso de Justificación de Incidencias en la puntualidad y asistencia</h1>
  <main class="main">
    <p><button ><a href="nuevaIncidencia.jsp?action=6">Nueva incidencia</a></button></p>
    <br> <br>
    <table border=1 width="60%">
    <thead>
    <tr> 
    <td>Folio</td>
    <td>Catalogo</td>
    <td>Fecha</td>
    <td>Status</td>
    </tr>
    </thead>
    <tbody>
    <% for (Incidencias i:list){
    	out.print("<tr>"
        +"<td>"+i.getFolio()+"</td>"+
        "<td>"+i.getCatalogo_id()+"</td>"+
        "<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
        "<td class='status'>"+i.getStatus()+"</td>"+
        "</tr>");
    	
    } %>
    </tbody>
    
    </table>
  </main>
  <script type="text/javascript" src="js/status.js"></script>
  <script src="js/1.js"></script>
   <script src="js/app2.js"></script>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>
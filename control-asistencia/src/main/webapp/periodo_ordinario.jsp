<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.tesoreria.Periodo"%>
<%@ page import="org.tesoreria.VacacionPO"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/periodo_ordinario.css">
  <link rel="stylesheet" href="css/format.css">
  <link rel="stylesheet" href="css/table.css">
  <link rel="stylesheet" href="css/buttonStat.css">
  <title>vacaciones PO</title>
  <%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
<jsp:include page="nav-admin.jsp"></jsp:include>
<%ArrayList<Periodo> listPeriodo; 
  listPeriodo = Periodo.getPeriodos();
  %>
  <h1>Aviso de vacaciones de servidores públicos en periodo ordinario</h1>
  <main class="main">
    <section class="main__contanier container">
     <%for (Periodo p : listPeriodo) {
		//out.print('<'+"option value="+u.getId_percepciones()+'>'+u.getNombre()+"</option>");
		out.print('<' + "button class='button_agregar button_periodos' value=" + p.getId_periodo() + '>' +
		'<'+"a class='ancla'" +"href="+"Vacacionespo_servlet?accion=5&p="+p.getId_periodo()+'>'+ p.getPeriodo() + "  PERIODO  " + p.getEtapa() + " ETAPA"
		+ "</a>"+"</button>");
		//out.print('<'+"option value="+p.getId_periodo()+'>'+p.getPeriodo()+" PERIODO "+p.getEtapa()+" ETAPA"+"</option");
	} %>
	<% 
  //ArrayList <Incidencias> incidenciasView = new ArrayList<Incidencias>();
  ArrayList<VacacionPO> listV = (ArrayList<VacacionPO>) request.getAttribute("listavacaciones"); %>
	<table width="90%" class="table_style">
    <thead>
    <tr> 
    <td>Clave de Servidor</td>
    <td>Nombre</td>
    <td>Puesto</td>
    <td>Fechas</td>
    <!--  <td>Status</td>-->
   
    </tr>
    </thead>
    <tbody>
    <%String  perfill =  (String) session.getAttribute("perfil");
    	if(listV!=null){
    for (VacacionPO vp:listV){
    	    	out.print("<tr>"
    	    	+"<td>"+vp.getClave_servidor()+"</td>"
    	    	+"<td>"+vp.getNombre()+"</td>"
    	    	+"<td>"+vp.getPuesto()+"</td>"
    	        +"<td>"+vp.getVacaciones()+"</td>"+
    	        
    	        //"<td>"+j.getNomS(j.getUsuario_id())+"</td>"+
    	    			
    	        //"<td>"+j.getNombre()+"</td>"+
    	        //"<td>"+j.getCausa()+"</td>"+
    	        //"<td>"+formatter.format(i.getFecha_justificacion())+"</td>"+
    	        //"<td class='status'>"+i.getStatus()+"</td>"+
    	        	//	"<td class='status'>"+i.getObservaciones()+"</td>"+
    	        //out.print('<'+"option value="+u.getUsuario_id()+'>'+u.getNombre()+"</option>");
    	        "</tr>");
    	    	
    	    }
    	}
     %>
    </section>
   
  </main>
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>
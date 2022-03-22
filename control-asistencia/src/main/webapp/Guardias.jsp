<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%if(session.getAttribute("theNickName")!=null){ %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css"
    rel="stylesheet" />

  <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"
    rel="stylesheet" >
    <link rel="stylesheet" href="css/date.css">
  <link rel="stylesheet" href="css/guardias.css">
  <link rel="stylesheet" href="css/format.css">
  <title>Guardias</title>
  <%
  //response.setHeader("Cache-Control", "no-cache, no-store, must-revaldiate");
  %>
</head>

<body>
<jsp:include page="nav-admin.jsp"></jsp:include>
  <h1>Guardias</h1>
  <p><button ><a href="nuevaGuardia.jsp?action=6">Nuevo Formato Guardias</a></button></p>
  <main class="main">
  </main>
    
</body>

</html>
<%}else{
	response.sendRedirect("index.jsp");
} %>
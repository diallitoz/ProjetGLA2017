<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="metier.entities.Compte"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultation solde compte</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />
	<!-- 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    Ionicons
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
   <!--  <style type="text/css">
    	th, td{
    		text-align: center;
    	}
    </style> -->
</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-10 col-md-offset-1  col-xs-12">
	
<div  class=" menu container col-md-2  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuPrestataire.jsp"%>
</div>


<div  class=" contenu container col-md-10  col-xs-7">

<div class=" panel panel-primary">

			<div class=" panel-heading">Consultation de solde compte</div>
			<div class=" panel-body">

				<form action="ConsulterComptePresta.php" method="get">
					<label for="idClient" >Numero Compte : </label> 
					<input type="number" name="idClient" id="idClient" value = "${compte.id }" min=1 required = "required" />
					<button type="submit" class="btn btn-primary">Consulter</button>

				</form>
				<br>
				<br>
				<br>
				
				<table class="table table-striped">
					<tr>
						<th>MON ID</th>
						<th>TYPE</th>
						<th>DATE</th>
						<th>ID GESTIONNAIRE</th>
						<th>SOLDE</th>
					</tr>
<%-- 					<%! NumberFormat c= NumberFormat.getInstance(java.util.Locale.FRENCH); 
						String cpte = c.format(((Compte)(request.getAttribute("compte"))).getSolde());
					%> --%>
					
					<%-- <% cpte = c.format(((Compte)(pageContext.findAttribute("compte"))).getSolde()); %> --%>
					
					<tr>

						<td>${compte.idClient}</td>
						<td>${compte.type}</td>
						<td>${date}</td>							
						<td>${compte.idGestionnaire }</td>
						<td>${soldeString} VND</td>
					</tr>
				</table>
			</div>

		</div>
</div>

</div>
 
 <%@include file="include/footer.jsp"%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script> $('.dropdown-toggle').dropdown()</script>

</body>
</html>
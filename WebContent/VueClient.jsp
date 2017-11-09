<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operations sur les clients</title>
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
    <!-- <style type="text/css">
    	th, td{
    		text-align: center;
    	}
    </style> -->
</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-12 col-md-offset-0  col-xs-12">
	
<%-- <div  class=" menu container col-md-2  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuGestionnaire.jsp"%>
</div> --%>


<!-- <div  class=" contenu container col-md-10  col-xs-7"> -->

<div class=" panel panel-primary">

			<div class=" panel-heading">Operations sur les clients </div>
			 
			<div class=" panel-body">
			<a href="Gestionnaire.jsp"><button class="btn btn-danger btn-lg">Menu Gestionnaire</button></a>
				<p style="margin-top: 10px"></p>

				<form action="OperationClient.php" method="get">
					<label for="idClient">Id Client </label> 
					<input type="number" name="idClient" id="idClient" value="${client.id}" min="1" required = "required" />
					<button type="submit" class="btn btn-primary">Appliquer</button>
				</form>
				
				<br>
				<br>
				
				<table class="table table-striped">
					<tr>
						<th>CIVILITE</th>
						<!-- <th>ID</th>-->
						
						<th>NOM</th>
						<th>PRENOM</th>
						<th>TYPE</th>
						<!-- <th>DATE DE NAISSANCE</th>
						<th>LIEU DE NAISSANCE</th> -->
						<!-- <th>SEXE</th> -->
						<!-- 
						<th>PIECE D'IDENTITE</th>
						<th>REFERENCE DE LA PIECE D'IDENTITE</th>
						<th>ADRESSE</th> -->
						<th>TELEPHONE</th>
						<th>EMAIL</th>
						<th>DETAILS</th>
						<th>SUPPRESSION</th>
						<th>CREATION COMPTE</th>
					</tr>
					<%-- //<c:forEach items="${modeleClient.listeClientRecherche}" var="client"> --%>
						<tr>
							<td>${client.civilite}</td>
							<%-- <td>${client.id}</td>
							<td>${client.civilite}</td> --%>
							<td>${client.nom}</td>
							<td>${client.prenom}</td>
							<td>${client.type}</td>
							<%-- <td>${client.dateNaissance}</td>
							<td>${client.lieuNaissance}</td> --%>
							<%-- <td>${client.sexe}</td> --%>
							<%-- 
							<td>${client.pieceIdentite}</td>
							<td>${client.refPieceIdentite}</td> --%>
							<%-- <td>${client.adresse}</td> --%>
							<td>${client.telephone}</td>
							<td>${client.email}</td>	
							<td><a href="ModifierClient.php?id=${client.id }"> Visualiser </a></td>
							<td><a onclick = "return confirm ('Voulez vous vraiment suppprimer ce client???')" href="SupprimerClient.php?id=${client.id }"> Supprimer </a></td>
							<td><a href="CreerCompte.php?id=${client.id }"> Creer compte </a></td>
						</tr>

					<%-- </c:forEach> --%>
				</table>
			</div>

		</div>
<!-- </div> -->

</div>
 
 <%@include file="include/footer.jsp"%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script> $('.dropdown-toggle').dropdown()</script>

</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche de compte</title>
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

	<style type="text/css">
    	th, td{
    		text-align: center;
    	}
    </style>

</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-10 col-md-offset-1  col-xs-12">
	
<div  class=" menu container col-md-2  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuGestionnaire.jsp"%>
</div>


<div  class=" contenu container col-md-10  col-xs-7">

<div class=" panel panel-primary">

			<div class=" panel-heading">Recherche de comptes client</div>
			<div class=" panel-body">

				<form action="ChercherCompte.php" method="get">
					<label>Mot cle </label> 
					<input type="search" name="motCle" id="motCle"	value="${modeleCpte.motCle}" />
					<button type="submit" class="btn btn-primary">ReChercher</button>

				</form>
				<br>
				<br>
			
				<table style="border:1px" class="table table-striped" >
					<tr>
						<th>ID</th>
						<th>TYPE</th>
						<th>DATE DE CREATION</th>
						<th>ID CLIENT</th>
						<th>ID GESTIONNAIRE</th>
						<th>SOLDE</th>
						<th>MODIFICATION</th>
						<th>SUPPRESSION</th>
						<th>VERSEMENT</th>
					</tr>
					<c:forEach items="${modeleCpte.listeCompteRecherche}" var="cpte">
						<tr>

							<td>${cpte.id}</td>
							<td>${cpte.type}</td>
							<td>${cpte.dateCreation}</td>
							<td>${cpte.idClient }</td>
							<td>${cpte.idGestionnaire }</td>
							<td>${cpte.solde}</td>
							<td><a href="ModifierCompte.php?id=${cpte.id }"> Modifier </a></td>
							<td><a onclick = "return confirm ('Voulez vous vraiment suppprimer ce compte')" href="SupprimerCompte.php?id=${cpte.id }"> Supprimer </a></td>
							<td><a href="CrediterCompte.php?id=${cpte.id }"> Crediter </a></td>
						</tr>

					</c:forEach>
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
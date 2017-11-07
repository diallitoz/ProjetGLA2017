<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation de la modification du client ${client.id}</title>
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
</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-10 col-md-offset-1  col-xs-12">
	
<div  class=" menu container col-md-2  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuGestionnaire.jsp"%>
</div>


<div  class=" contenu container col-md-10  col-xs-7">

<div class=" panel panel-primary">

			<div class=" panel-heading">Modifications effectuees avec SUCCESS
			</div>
			<div class=" panel-body">
				<div class="form-group">
					<label> ID CLIENT :  </label> <label> ${client.id}</label>
				</div>

				<div class="form-group">
					<label> Civilite :  </label> 
					<label> ${client.civilite}</label>
				</div>

				<div class="form-group">
					<label> Nom :  </label> 
					<label> ${client.nom}</label>
				</div>

				<div class="form-group">
					<label> Prenom :  </label> 
					<label> ${client.prenom}</label>
				</div>

				<div class="form-group">
					<label> Date de naissance :  </label> <label>
						${client.dateNaissance}</label>
				</div>

				<div class="form-group">
					<label> Lieu de naissance :  </label> 
					<label> ${client.lieuNaissance}</label>

				</div>
				
				<div class="form-group">
					<label> Sexe :  </label> 
					<label> ${client.sexe}</label>

				</div>
				
				<div class="form-group">
					<label> Type :  </label> 
					<label> ${client.type}</label>

				</div>
				
				<div class="form-group">
					<label> Piece d'identite :  </label> 
					<label> ${client.pieceIdentite}</label>

				</div>
				
				<div class="form-group">
					<label> Reference piece d'idente :  </label> 
					<label> ${client.refPieceIdentite}</label>

				</div>
				
				<div class="form-group">
					<label> Adresse :  </label> 
					<label> ${client.adresse}</label>

				</div>
				
				<div class="form-group">
					<label> Telephone :  </label> 
					<label> ${client.telephone}</label>

				</div>
				
				<div class="form-group">
					<label> Email :  </label> 
					<label> ${client.email}</label>

				</div>
				
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
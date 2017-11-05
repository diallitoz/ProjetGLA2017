<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administration</title>
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
	
<div  class=" menu container col-md-3  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuAdministrateur.jsp"%>
</div>


<div  class=" contenu container col-md-9  col-xs-7">

<div class=" panel panel-primary">

			<div class=" panel-heading">Modification de compte client</div>
			<div class=" panel-body">
				<form action="ModificationCompte.php" method="post">
					<div class="form-group">
						<label class=" control-label "> Id </label> 
						<input type="hidden" name="id" class="form-control" value = "${compte.id }" required = "required" /> <span></span>
						<label class=" control-label "> ${compte.id } </label> 
					</div>
					
					<div class="form-group">
						<label for="type" class=" control-label "> Type de compte* </label> 
						<%-- <input type="text" name="type" id="type" class="form-control" value = "${compte.type }" required = "required" /> <span></span> --%>
					
						&nbsp;
						&nbsp;
						<input type="radio" name="type" value="Prestataire" id="Prestataire" required = "required" /> <label for="Prestataire">Prestataire</label>
						
						&nbsp;
						&nbsp;
						<input type="radio" name="type" value="Etudiant" id="Etudiant" required = "required" /> <label for="Etudiant">Etudiant</label>
					</div>
					<div class="form-group">
						<label class=" control-label "> Date* </label> 
						<input type="text" name="date" class="form-control" value = "${compte.dateCreation }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label class=" control-label "> Id Client* </label> 
						<input type="text" name="idClient" class="form-control" value = "${compte.idClient }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label class=" control-label "> Id Gestionnaire* </label> <input
							type="text" name="idGestionnaire" class="form-control" value = "${compte.idGestionnaire }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label class=" control-label "> Solde* </label> 
						<input type="text" name="solde" class="form-control" value = "${compte.solde }" required = "required" /> <span></span>
					</div>

					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
						
						<button type="reset" class="btn btn-primary">Renitialiser</button>

					</div>

				</form>

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
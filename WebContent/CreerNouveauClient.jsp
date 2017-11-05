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

			<div class=" panel-heading">Creer un nouveau Client</div>
			<div class=" panel-body">
				<form action="EnregistrerClient.php" method="post">
					
					<div class="form-group">
						<label for="civilite" class=" control-label "> Civilite* </label> 
						&nbsp;
						&nbsp;
						<input type="radio" name="civilite" value="Monsieur" id="Monsieur" required = "required" /> <label for="Monsieur">Monsieur</label>
						&nbsp;
						&nbsp;
						<input type="radio" name="civilite" value="Madame" id="Madame" required = "required" /> <label for="Madame">Madame</label>
						&nbsp;
						&nbsp;
						<input type="radio" name="civilite" value="Mademoiselle" id="Mademoiselle" required = "required" /> <label for="Mademoiselle">Mademoiselle</label>
						
						<span></span>
					</div>
					
					<div class="form-group">
						<label for="nom" class=" control-label "> Nom* </label> 
						<input type="text"	name="nom" id="nom" class="form-control" value = "${client.nom }" required = "required" /> <span></span>
					</div>
					
					<div class="form-group">
						<label for="prenom" class=" control-label "> Prenom* </label> 
						<input type="text" name="prenom" id="prenom" class="form-control" value = "${client.prenom }" required = "required" /> <span></span>
					</div>
					
					
					<div class="form-group">
						<label for="dateNaissance" class=" control-label "> Date de naissance* </label> 
						<input type="text"	name="dateNaissance" id="dateNaissance" class="form-control" value = "${client.dateNaissance }" required = "required" /> <span></span>
					</div>
					
					<div class="form-group">
						<label for="lieuNaissance" class=" control-label "> Lieu de naissance* </label> 
						<input type="text"	name="lieuNaissance" id="lieuNaissance" class="form-control" value = "${client.lieuNaissance }" required = "required" /> <span></span>
					</div>
					
					<div class="form-group">
						<label for="type" class=" control-label "> Sexe* </label> 
						<%-- <input type="text" name="sexe" id="type" class="form-control" value = "${client.sexe }" required = "required" /> <span></span> --%>
					
						&nbsp;
						&nbsp;
						<input type="radio" name="sexe" value="Masculin" id="Masculin" required = "required" /> <label for="Prestataire">Masculin</label>
						
						&nbsp;
						&nbsp;
						<input type="radio" name="sexe" value="Feminin" id="Feminin" required = "required" /> <label for="Etudiant">Feminin</label>
						
					</div>
					
					
					<div class="form-group">
						<label for="type" class=" control-label "> Type de Client* </label> 
						<%-- <input type="text" name="type" id="type" class="form-control" value = "${client.type }" required = "required" /> <span></span> --%>
					
						&nbsp;
						&nbsp;
						<input type="radio" name="type" value="Prestataire" id="Prestataire" required = "required" /> <label for="Prestataire">Prestataire</label>
						
						&nbsp;
						&nbsp;
						<input type="radio" name="type" value="Etudiant" id="Etudiant" required = "required" /> <label for="Etudiant">Etudiant</label>
						
					</div>
					
					
					<div class="form-group">
						<label for="pieceIdentite" class=" control-label "> Type de piece d'identite* </label> 
						&nbsp;
						&nbsp;
						<input type="radio" name="pieceIdentite" value="Passport" id="Passport" required = "required" /> <label for="Passport">Passport</label>
						
						&nbsp;
						&nbsp;
						<input type="radio" name="pieceIdentite" value="Carte d'identite nationale" id="Carte d'identite nationale" required = "required" /> <label for="Carte d'indite">Carte d'identite nationale</label>
						
						&nbsp;
						&nbsp;
						<input type="radio" name="pieceIdentite" value="Carte d'etudiant" id="Carte d'etudiant" required = "required" /> <label for="Carte d'etudiant">Carte d'etudiant</label>
						
						
					</div>
					<div class="form-group">
					<label for="refPieceIdentite" class=" control-label "> Reference de la Piece* </label> 
						<input type="text" name="refPieceIdentite" id="refPieceIdentite" class="form-control" value = "${client.refPieceIdentite }" required = "required" /> <span></span>
						<span></span>
					</div>
					
					<div class="form-group">
						<label for="adresse" class=" control-label "> Adresse* </label> 
						<input type="text"	name="adresse" id="adresse" class="form-control" value = "${client.adresse }" required = "required" /> <span></span>
					</div>
					
					<div class="form-group">
						<label for="telephone" class=" control-label "> Telephone* </label>
						 <input type="text"	name="telephone" id="telephone" class="form-control" value = "${client.telephone }" required = "required" /> <span></span>
					</div>
					
					<div class="form-group">
						<label for="email" class=" control-label "> Email* </label> <input type="text"
							name="email" id="email" class="form-control" value = "${client.email }" required = "required" /> <span></span>
					</div>

					<div>
						<button type="submit" class="btn btn-primary">Creer</button>
						
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
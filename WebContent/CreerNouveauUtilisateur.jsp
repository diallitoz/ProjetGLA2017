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
	
<div  class=" menu container col-md-2  col-xs-3"><!-- Menu Administrateur -->

<%@include file="include/menuAdministrateur.jsp"%>
</div>

<div  class=" contenu container col-md-10  col-xs-7">
<div class=" panel panel-primary">

			<div class=" panel-heading">Creer un nouveau utilisateur</div>
			<div class=" panel-body">
				<form action="EnregistrerUtilisateur.php" method="post">
					
					<div class="form-group">
					<label for="profil">Profil*</label><br />

       				<select name="profil" id="profil">

               			 <option value="Administrateur">Administrateur</option>

              			 <option value="Gestionnaire Principal">Gestionnaire Principal</option>

              			 <option value="Gestionnaire">Gestionnaire</option>

              			 <option value="Prestataire">Prestataire</option>
              			 
              			 <option value="Etudiant">Etudiant</option>

     			  </select>
     			  
     			  </div>
     			 
					<div class="form-group">
						<label for="login" class=" control-label "> Login* </label>
						<input type="date"	name="login" id="login" class="form-control" value = "${user.login }" required = "required"/> <span></span>
					</div>
					
					<div class="form-group">
						<label for="password" class=" control-label "> Password* </label> 
						<input type="text" name="password" id="password" class="form-control" value = "${user.password }" required = "required"/> <span></span>
					</div>
					
					<div class="form-group">
						<label for="email" class=" control-label "> Email* </label> <input
							type="text" name="email" id="email" class="form-control" value = "${user.email }" required = "required"/> <span></span>
					</div>
					
					<div class="form-group">
					
					<label for="civilite" class=" control-label "> Status* </label> 
						&nbsp;
						&nbsp;
						<input type="radio" name="status" value="Active" id="Active" required = "required" /> <label for="Active">Active</label>
						&nbsp;
						&nbsp;
						<input type="radio" name="status" value="Non active" id="Non active" required = "required" /> <label for="Non active">Non active</label>
						
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
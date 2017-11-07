<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'un utilisateur</title>
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

			<div class=" panel-heading">Modification de utilisateur</div>
			<div class=" panel-body">
				<form action="ModificationUtilisateur.php" method="post">
					<div class="form-group">
						<label class=" control-label "> Id </label> 
						<input type="hidden" name="id" class="form-control" value = "${user.id }" required = "required" /> <span></span>
						<label class=" control-label "> ${user.id} </label> 
					</div>
					
					<div class="form-group">
						<label for="profil" class=" control-label "> Profil* </label>
						<input type="text" name="profil" id="profil" class="form-control" value = "${user.profil }" required = "required" /> <span></span>
					</div>
					<div class="form-group">
						<label for="login" class=" control-label "> Login* </label> 
						<input type="text" name="login" class="form-control" value = "${user.login }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label for="password"  class=" control-label "> Password* </label> 
						<input type="text" name="password" class="form-control" value = "${user.password }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label for="email" class=" control-label "> Email* </label> <input
							type="text" name="email" class="form-control" value = "${user.email }" required = "required"/> <span></span>
					</div>
					<div class="form-group">
						<label for="status" class=" control-label "> Status* </label> 
						<input type="text" name="status" class="form-control" value = "${user.status }" required = "required" /> <span></span>
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
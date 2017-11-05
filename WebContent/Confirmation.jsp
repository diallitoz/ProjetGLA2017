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

			<div class=" panel-heading">Confirmation de creation du Compte
				client</div>
			<div class=" panel-body">
				<div class="form-group">
					<label> ID COMPTE :  </label> <label> ${compte.id}</label>
				</div>

				<div class="form-group">
					<label> Type :  </label> <label> ${compte.type}</label>
				</div>

				<div class="form-group">
					<label> Date de creation :  </label> <label> ${compte.dateCreation}</label>
				</div>

				<div class="form-group">
					<label> Id Client :  </label> <label> ${compte.idClient}</label>
				</div>

				<div class="form-group">
					<label> Id Gestionnaire :  </label> <label>
						${compte.idGestionnaire}</label>
				</div>

				<div class="form-group">
					<label> Solde :  </label> <label> ${compte.solde}</label> VND

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
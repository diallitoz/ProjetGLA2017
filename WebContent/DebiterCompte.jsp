<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Debiter un compte</title>
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

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<div class=" panel panel-primary">

			<div class=" panel-heading">Versement d'argent dans un compte</div>
			<div class=" panel-body">
				<form action="VersementCompte.php" method="post">
					<div class="form-group">
						<label class=" control-label "> Date de versement : </label> &nbsp;&nbsp;&nbsp;
						<input type="hidden" name="dateVersement" class="form-control" value = "${date}" required = "required" /> <span></span>
						<label class=" control-label "> ${date} </label> 
					</div>
					
					<div class="form-group">
						<label for="id" class=" control-label "> Numero Compte du benificiaire : </label> &nbsp;&nbsp;&nbsp;
						<input type="hidden" name="id" id="id" class="form-control" value = "${compte.id }" required = "required" /> <span></span>
						<label class=" control-label "> ${compte.id} </label> 
					</div>
					
					<div class="form-group">
						<label for="montnat" class=" control-label "> Montant a verser* : </label>
						<input type="number" name="montant" id="montant" class="form-control" placeholder = "Veuiller saisir le montant VND" required = "required" min=1 style="width:300px;"/><span></span>
						<!-- <label class=" control-label "> VND </label>  -->
					</div>
				
					<div>
						<button type="submit" class="btn btn-primary">Debiter</button>
						
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
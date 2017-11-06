<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de connexion</title>
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

 <header >

<div  class=" barreBleue container col-md-10 col-md-offset-1  col-xs-12"></div>

<div  class=" container col-md-10 col-md-offset-1  col-xs-12">
	<img alt="logo VNU" src="image/logoDHQG.jpg" height="120px"> 
	<img alt="logo VNU" src="image/ktx.jpg" width="100px" height="120px" align="right">
</div>

<div  class="barreBleue container col-md-10 col-md-offset-1  col-xs-12">
</div>

</header>


<div class=" panel panel-primary col-md-4 col-md-offset-4 col-xs-7" style="margin-top: 20px">

			<div class=" panel-heading">Entrez votre identifiant et votre mot de passe pour vous connecter!
				
			</div>
			<div class=" panel-body">

				<form method="post" action="controleurLogin.php">

					<div class="form-group">
					<label for="pseudo">Nom d'utilisateur :</label> 
					<input type="text" name="login" id="pseudo" required/> <br /> 
					</div>	
						
					<div class="form-group">	
					<label for="pass">Mot de passe :</label> 
					<input type="password" name="password" id="pass" required/>
					</div>	

					<div>
						<button type="submit" class="btn btn-primary">Connexion</button>
						<a href="RenitialiserMotDePasse.php"> Cliquez ici si vous avez oublié votre
							mot de passe </a>

					</div>

				</form>
			</div>

		</div>

<img alt="Globe terreste" src="image/Global3.jpg" align="right" >


 
 <%@include file="include/footer.jsp"%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script> $('.dropdown-toggle').dropdown()</script>

</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Historiques des payements recus par un prestataire</title>
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

<!-- 	<style type="text/css">
    	th, td{
    		text-align: center;
    	}
    </style> -->

</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-10 col-md-offset-1  col-xs-12">
	
<div  class=" menu container col-md-2  col-xs-3"><!-- Menu Prestataire -->

<%@include file="include/menuPrestataire.jsp"%>
</div>


<div  class=" contenu container col-md-10  col-xs-7">

<div class=" panel panel-primary">

			<div class=" panel-heading">Historiques des payements pour le compte de ${sId}/${sLogin} </div>
			<div class=" panel-body">

				<form action="HistoriquePayementPresta.php" method="get">
					<label>Numero de compte : </label> 
					<input type="number" name="iDCompte" id="iDCompte" required="required" min=1 value="${modelePayement.idCompte}"/>
					&nbsp;
					&nbsp;
					&nbsp;
					
					<label>Mot cle : </label> 
					<input type="search" name="motCle" id="motCle"	value="${modelePayement.motCle}" />
					
					
					<button type="submit" class="btn btn-primary">ReChercher</button>

				</form>
				<br>
				<br>
			
				<table style="border:1px" class="table table-striped" >
					<tr>
						<th>ID</th>
						<th>TYPE</th>
						<th>MONTANT</th>
						<th>COMPTE PAYEUR</th>
						<th>DATE </th>
						
						<th>IMPRIMER</th>
						<th>EXPORTER</th>
						
					</tr>
					<c:forEach items="${modelePayement.listePayementRecherche}" var="payement">
						<tr>

							<td>${payement.id}</td>
							<td>${payement.type}</td>
							<td>${payement.montant }</td>
							<td>${payement.idComptePayeur }</td>
							<td>${payement.datePayement}</td>
							
							
							
							<td><a href="#"> Imprimer </a></td>
							<td><a href="#"> Exporter </a></td>
							
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
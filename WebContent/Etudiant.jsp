<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil Etudiant</title>
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
    <link rel="stylesheet" media="screen, print, handheld" type="text/css" href="include/calendrier.css" />
	<script type="text/javascript" src="include/calendrier.js"></script>
</head>
<body>

 <%@include file="include/header.jsp"%>
 
 <div  class=" blocContenu container col-md-10 col-md-offset-1  col-xs-12">
	
<div  class=" menu container col-md-2  col-xs-3" style="fon: white;"><!-- Menu Etdudiant -->

<%@include file="include/menuEtudiant.jsp"%>

</div>


<div style="background-color:white"  class=" contenu container col-md-10  col-xs-7">
<!-- <img alt="Globe terreste" src="image/Global3.jpg" align="right" > -->
<img class="img-responsive" alt="OnlineShopping" src="image/OnlineShopping.jpg" width="auto" height="auto" align="right"  >
<!-- width="100px" height="120px" align="right" -->

<!-- <div id="calendarMain" class="calendarMain">
<script type="text/javascript">
calendrier();
</script>
</div> -->
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
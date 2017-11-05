
<%
	String check = (String) session.getAttribute("skey");
	String login = "";

	if (check != null) {
		login = (String) session.getAttribute("sLogin");
		

	} else {
		response.sendRedirect("index.jsp");
	}
%>
<header >

<div  class=" barreBleue container col-md-10 col-md-offset-1  col-xs-12"></div>

<div  class=" container col-md-10 col-md-offset-1  col-xs-12">
	<img alt="logo VNU" src="image/logoDHQG.jpg" height="120px"> 
	<img alt="logo VNU" src="image/ktx.jpg" width="100px" height="120px" align="right">
</div>

<div  class=" barreBleue container col-md-10 col-md-offset-1  col-xs-12">
Bienvenue <%=login%> &nbsp;&nbsp; &nbsp;	&nbsp;<a href="index.jsp">logout</a></div>
 
</header>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html lang="es_AR">
<head>
<meta charset="UTF-8">

<title>Informacion de Cuenta</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>


	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<div class="page-title">Informacion de Cuenta</div>

	<div class="account-container">


		<ul>
			<li>Nombre de Usuario: ${pageContext.request.userPrincipal.name}</li>
			<li>Rol:
				<ul>
					<c:forEach items="${userDetails.authorities}" var="auth">
						<li>${auth.authority }</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div>


	<jsp:include page="_footer.jsp" />

</body>
</html>
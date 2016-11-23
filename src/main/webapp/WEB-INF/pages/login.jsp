<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es_AR">
<head>
<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>


	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />



	<div class="page-title">Login</div>

	<div class="login-container">

		<h3>Ingrese el usuario y la clave</h3>
		<br>
		<!-- /login?error=true -->
		<c:if test="${param.error == 'true'}">
			<div style="color: red; margin: 10px 0px;">

				Login Incorrecto!!!<br /> Razon :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

			</div>
		</c:if>

		<form method="POST"
			action="${pageContext.request.contextPath}/j_spring_security_check">
			<table>
				<tr>
					<td>Nombre de Usuario:</td>
					<td><input name="userName" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Entrar" /> <input
						type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>

		<span class="error-message">${error }</span>

	</div>


	<jsp:include page="_footer.jsp" />

</body>
</html>
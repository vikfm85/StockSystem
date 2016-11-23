<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="es_AR">
<head>
<meta charset="UTF-8">

<title>Ingresar Informacion de Cliente</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<div class="page-title">Ingresar Informacion de Cliente</div>

	<form:form method="POST" modelAttribute="customerForm"
		action="${pageContext.request.contextPath}/shoppingCartCustomer">

		<table>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" class="error-message" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" class="error-message" /></td>
			</tr>

			<tr>
				<td>Telefono:</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" class="error-message" /></td>
			</tr>

			<tr>
				<td>Direccion:</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" class="error-message" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Enviar" /> <input type="reset"
					value="Reset" /></td>
			</tr>
		</table>

	</form:form>


	<jsp:include page="_footer.jsp" />


</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">
<title>Producto</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<div class="page-title">Producto</div>

	<c:if test="${not empty errorMessage }">
		<div class="error-message">${errorMessage}</div>
	</c:if>

	<form:form modelAttribute="productForm" method="POST"
		enctype="multipart/form-data">
		<table style="text-align: left;">
			<tr>
				<td>Codigo:</td>
				<td style="color: red;"><c:if
						test="${not empty productForm.code}">
						<form:hidden path="code" />
                        ${productForm.code}
                   </c:if> <c:if test="${empty productForm.code}">
						<form:input path="code" />
						<form:hidden path="newProduct" />
					</c:if></td>
				<td><form:errors path="code" class="error-message" /></td>
			</tr>

			<tr>
				<td>Nombre:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" class="error-message" /></td>
			</tr>

			<tr>
				<td>Precio:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" class="error-message" /></td>
			</tr>
			<tr>
				<td>Imagen</td>
				<td><img
					src="${pageContext.request.contextPath}/productImage?code=${productForm.code}"
					width="100" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Subir Imagen</td>
				<td><form:input type="file" path="fileData" /></td>
				<td></td>
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
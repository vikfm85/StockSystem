<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="es_AR">
<head>
<meta charset="UTF-8">

<title>Mi Carro</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	<jsp:include page="_header.jsp" />

	<jsp:include page="_menu.jsp" />

	<fmt:setLocale value="es_AR" scope="session" />

	<div class="page-title">Mi Carro</div>

	<c:if test="${empty cartForm or empty cartForm.cartLines}">
		<h2>No hay productos en el carro</h2>
		<a href="${pageContext.request.contextPath}/productList">Mostrar
			Lista de Productos</a>
	</c:if>

	<c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
		<form:form method="POST" modelAttribute="cartForm"
			action="${pageContext.request.contextPath}/shoppingCart">

			<c:forEach items="${cartForm.cartLines}" var="cartLineInfo"
				varStatus="varStatus">
				<div class="product-preview-container">
					<ul>
						<li><img class="product-image"
							src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" />
						</li>
						<li>Codigo: ${cartLineInfo.productInfo.code} <form:hidden
								path="cartLines[${varStatus.index}].productInfo.code" />

						</li>
						<li>Nombre: ${cartLineInfo.productInfo.name}</li>
						<li>Precio: <span class="price"> <fmt:formatNumber
									value="${cartLineInfo.productInfo.price}" type="currency" />

						</span></li>
						<li>Cantidad: <form:input
								path="cartLines[${varStatus.index}].quantity" /></li>
						<li>Subtotal: <span class="subtotal"> <fmt:formatNumber
									value="${cartLineInfo.amount}" type="currency" />

						</span>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${cartLineInfo.productInfo.code}">
								Eliminar </a></li>
					</ul>
				</div>
			</c:forEach>
			<div style="clear: both"></div>
			<input class="button-update-sc" type="submit"
				value="Actualizar Cantidad" />
			<a class="navi-item"
				href="${pageContext.request.contextPath}/shoppingCartCustomer">Ingresar
				Info de Cliente</a>
			<a class="navi-item"
				href="${pageContext.request.contextPath}/productList">Continuar
				con la Orden</a>
		</form:form>


	</c:if>


	<jsp:include page="_footer.jsp" />

</body>
</html>
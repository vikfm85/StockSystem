<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<fmt:setLocale value="en_ES" scope="session" />

	<div class="page-title">Lista de Productos</div>



	<c:forEach items="${paginationProducts.list}" var="prodInfo">
		<div class="product-preview-container">
			<ul>
				<li><img class="product-image"
					src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" /></li>
				<li>Codigo: ${prodInfo.code}</li>
				<li>Nombre: ${prodInfo.name}</li>
				<li>Precio: <fmt:formatNumber value="${prodInfo.price}"
						type="currency" /></li>
				<li><a
					href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
						Ordenar</a></li>
				<!-- For Manager edit Product -->
				<security:authorize access="hasRole('ROLE_MANAGER')">
					<li><a style="color: yellow;"
						href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
							Editar Producto</a></li>
					<li><a style="color: red;"
						href="${pageContext.request.contextPath}/productRemoveProduct?code=${prodInfo.code}">
							Eliminar Producto</a></li>

				</security:authorize>
			</ul>
		</div>

	</c:forEach>
	<br />


	<c:if test="${paginationProducts.totalPages > 1}">
		<div class="page-navigator">
			<c:forEach items="${paginationProducts.navigationPages}" var="page">
				<c:if test="${page != -1 }">
					<a href="productList?page=${page}" class="nav-item">${page}</a>
				</c:if>
				<c:if test="${page == -1 }">
					<span class="nav-item"> ... </span>
				</c:if>
			</c:forEach>

		</div>
	</c:if>

	<jsp:include page="_footer.jsp" />

</body>
</html>
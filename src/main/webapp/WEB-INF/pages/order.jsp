<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es_AR">
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<fmt:setLocale value="es_AR" scope="session" />

	<div class="page-title">Informacion de Orden</div>

	<div class="customer-info-container">
		<h3>Informacion del Cliente:</h3>
		<ul>
			<li>Nombre: ${orderInfo.customerName}</li>
			<li>Email: ${orderInfo.customerEmail}</li>
			<li>Telefono: ${orderInfo.customerPhone}</li>
			<li>Direccion: ${orderInfo.customerAddress}</li>
		</ul>
		<h3>Resumen de la Orden:</h3>
		<ul>
			<li>Total: <span class="total"> <fmt:formatNumber
						value="${orderInfo.amount}" type="currency" />
			</span></li>
		</ul>
	</div>

	<br />

	<table border="1" style="width: 100%">
		<tr>
			<th>Codigo de Producto</th>
			<th>Nombre del Producto</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Total</th>
		</tr>
		<c:forEach items="${orderInfo.details}" var="orderDetailInfo">
			<tr>
				<td>${orderDetailInfo.productCode}</td>
				<td>${orderDetailInfo.productName}</td>
				<td>${orderDetailInfo.quanity}</td>
				<td><fmt:formatNumber value="${orderDetailInfo.price}"
						type="currency" /></td>
				<td><fmt:formatNumber value="${orderDetailInfo.amount}"
						type="currency" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paginationResult.totalPages > 1}">
		<div class="page-navigator">
			<c:forEach items="${paginationResult.navigationPages}" var="page">
				<c:if test="${page != -1 }">
					<a href="orderList?page=${page}" class="nav-item">${page}</a>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">
<title>Lista de Producto</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_menu.jsp" />

	<fmt:setLocale value="es_ES" scope="session" />

	<div class="page-title">Lista de Orden</div>

	<div>Cantidad Total de Ordenes: ${paginationResult.totalRecords}</div>

	<table border="1" style="width: 100%">
		<tr>
			<th>Numero de Orden</th>
			<th>Fecha de la Orden</th>
			<th>Nombre del Cliente</th>
			<th>Direccion del Cliente</th>
			<th>Email del Cliente</th>
			<th>Total</th>
			<th>Vista</th>
		</tr>
		<c:forEach items="${paginationResult.list}" var="orderInfo">
			<tr>
				<td>${orderInfo.orderNum}</td>
				<td><fmt:formatDate value="${orderInfo.orderDate}"
						pattern="dd-MM-yyyy HH:mm" /></td>
				<td>${orderInfo.customerName}</td>
				<td>${orderInfo.customerAddress}</td>
				<td>${orderInfo.customerEmail}</td>
				<td style="color: red;"><fmt:formatNumber
						value="${orderInfo.amount}" type="currency" /></td>
				<td><a
					href="${pageContext.request.contextPath}/order?orderId=${orderInfo.id}">
						View</a></td>
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
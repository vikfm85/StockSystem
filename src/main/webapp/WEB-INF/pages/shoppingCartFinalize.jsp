<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es_ES">
<head>
<meta charset="UTF-8">

<title>Fin de la Orden</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	<jsp:include page="_header.jsp" />

	<jsp:include page="_menu.jsp" />

	<div class="page-title">Fin</div>

	<div class="container">
		<h3>Gracias por su Orden</h3>
		Su numero de orden es: ${lastOrderedCart.orderNum}
	</div>

	<jsp:include page="_footer.jsp" />

</body>
</html>
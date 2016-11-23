<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<div class="menu-container">

	<a href="${pageContext.request.contextPath}/">Home</a> | <a
		href="${pageContext.request.contextPath}/productList"> Lista de 
		Producto </a> | <a href="${pageContext.request.contextPath}/shoppingCart">
		Mi Carro </a> |
	<security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE')">
		<a href="${pageContext.request.contextPath}/orderList"> Lista de Ordenes
		</a>
     |
   </security:authorize>

	<security:authorize access="hasRole('ROLE_MANAGER')">
		<a href="${pageContext.request.contextPath}/product"> Crear
			Producto </a>
         |
   </security:authorize>

</div>
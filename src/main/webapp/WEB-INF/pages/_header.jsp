<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header-container">

	<div class="site-name">Sistema de Stock Online</div>

	<div class="header-bar">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
        Bienvenido
           <a href="${pageContext.request.contextPath}/accountInfo">
				${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Desconectar</a>

		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<a href="${pageContext.request.contextPath}/login">Ingresar</a>
		</c:if>
	</div>
</div>
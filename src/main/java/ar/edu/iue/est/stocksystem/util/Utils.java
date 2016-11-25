package ar.edu.iue.est.stocksystem.util;

import javax.servlet.http.HttpServletRequest;

import ar.edu.iue.est.stocksystem.model.CartInfo;

/**
 * Clase de utilidades
 * 
 * @author vikfm1985
 *
 */
public class Utils {

	// Productos en el carro, guardados en la sesion.
	public static CartInfo getCartInSession(HttpServletRequest request) {

		// Obtener el carro de la sesion.
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

		// Si es nulo, lo creo.
		if (cartInfo == null) {
			cartInfo = new CartInfo();

			// Guardo la sesion.
			request.getSession().setAttribute("myCart", cartInfo);
		}

		return cartInfo;
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	}

}
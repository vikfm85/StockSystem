package ar.edu.iue.est.stocksystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.iue.est.stocksystem.dao.OrderDAO;
import ar.edu.iue.est.stocksystem.dao.ProductDAO;
import ar.edu.iue.est.stocksystem.entity.Product;
import ar.edu.iue.est.stocksystem.model.OrderDetailInfo;
import ar.edu.iue.est.stocksystem.model.OrderInfo;
import ar.edu.iue.est.stocksystem.model.PaginationResult;
import ar.edu.iue.est.stocksystem.model.ProductInfo;
import ar.edu.iue.est.stocksystem.validator.ProductInfoValidator;

/**
 * Clase del controlador del Admin (Manager)
 * 
 * @author vikfm1985
 *
 */
@Controller
// Habilita las transacciones con Hibernate.
@Transactional
@EnableWebMvc
public class AdminController {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductInfoValidator productInfoValidator;

	// Configurado en ApplicationContextConfig.
	@SuppressWarnings("unused")
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == ProductInfo.class) {
			dataBinder.setValidator(productInfoValidator);
			// Para Subir Imagenes.
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}

	// GET: Muestra la pag de Login
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping({ "/productRemoveProduct" })
	public String removeProduct(Model model, //
			@RequestParam(value = "code", defaultValue = "") String code) {
		Product product = null;
		if (code != null && code.length() > 0) {
			product = productDAO.findProduct(code);
		}
		if (product != null) {

			ProductInfo productInfo = new ProductInfo(product);

			productDAO.delete(productInfo);

		}
		// Redirecciona a la pagina productList.
		return "redirect:/productList";
	}

	@RequestMapping(value = { "/accountInfo" }, method = RequestMethod.GET)
	public String accountInfo(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.isEnabled());

		model.addAttribute("userDetails", userDetails);
		return "accountInfo";
	}

	@RequestMapping(value = { "/orderList" }, method = RequestMethod.GET)
	public String orderList(Model model, //
			@RequestParam(value = "page", defaultValue = "1") String pageStr) {
		int page = 1;
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
		}
		final int MAX_RESULT = 5;
		final int MAX_NAVIGATION_PAGE = 10;

		PaginationResult<OrderInfo> paginationResult //
				= orderDAO.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);

		model.addAttribute("paginationResult", paginationResult);
		return "orderList";
	}

	// GET: Muestra el Producto.
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
		ProductInfo productInfo = null;

		if (code != null && code.length() > 0) {
			productInfo = productDAO.findProductInfo(code);
		}
		if (productInfo == null) {
			productInfo = new ProductInfo();
			productInfo.setNewProduct(true);
		}
		model.addAttribute("productForm", productInfo);
		return "product";
	}

	// POST: Guarda el producto
	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	// Evita la excepcion UnexpectedRollbackException
	@Transactional(propagation = Propagation.NEVER)
	public String productSave(Model model, //
			@ModelAttribute("productForm") @Validated ProductInfo productInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "product";
		}
		try {
			productDAO.save(productInfo);
		} catch (Exception e) {

			String message = e.getMessage();
			model.addAttribute("message", message);
			// Muestra el form del producto.
			return "product";

		}
		return "redirect:/productList";
	}

	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public String orderView(Model model, @RequestParam("orderId") String orderId) {
		OrderInfo orderInfo = null;
		if (orderId != null) {
			orderInfo = this.orderDAO.getOrderInfo(orderId);
		}
		if (orderInfo == null) {
			return "redirect:/orderList";
		}
		List<OrderDetailInfo> details = this.orderDAO.listOrderDetailInfos(orderId);
		orderInfo.setDetails(details);

		model.addAttribute("orderInfo", orderInfo);

		return "order";
	}

}
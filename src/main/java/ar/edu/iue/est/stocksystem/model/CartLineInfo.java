package ar.edu.iue.est.stocksystem.model;

/**
 * Clase donde creo el modelo de la informacion detallada del carro
 * 
 * @author vikfm1985
 *
 */
public class CartLineInfo {

	private ProductInfo productInfo;
	private int quantity;

	public CartLineInfo() {
		this.quantity = 0;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return this.productInfo.getPrice() * this.quantity;
	}

}
package ar.edu.iue.est.stocksystem.dao;

import ar.edu.iue.est.stocksystem.entity.Product;
import ar.edu.iue.est.stocksystem.model.PaginationResult;
import ar.edu.iue.est.stocksystem.model.ProductInfo;

public interface ProductDAO {

	public Product findProduct(String code);

	public ProductInfo findProductInfo(String code);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

	public void save(ProductInfo productInfo);

	public void delete(ProductInfo productInfo);

}
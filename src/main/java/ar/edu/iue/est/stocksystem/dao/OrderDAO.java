package ar.edu.iue.est.stocksystem.dao;

import java.util.List;

import ar.edu.iue.est.stocksystem.model.CartInfo;
import ar.edu.iue.est.stocksystem.model.OrderDetailInfo;
import ar.edu.iue.est.stocksystem.model.OrderInfo;
import ar.edu.iue.est.stocksystem.model.PaginationResult;

public interface OrderDAO {

	public void saveOrder(CartInfo cartInfo);

	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

	public OrderInfo getOrderInfo(String orderId);

	public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

}
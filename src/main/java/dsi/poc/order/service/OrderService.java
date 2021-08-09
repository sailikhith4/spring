package dsi.poc.order.service;

import java.util.List;
import java.util.Optional;

import dsi.poc.order.model.OrderEntity;

public interface OrderService {
	
	public OrderEntity findById(long id);
	public List<OrderEntity> getOrders();
	public OrderEntity createOrder(OrderEntity orderEntity);

}

package dsi.poc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.poc.order.model.OrderEntity;
import dsi.poc.order.repository.OrderJpaRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderJpaRepository repository;

	@Override
	public OrderEntity findById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<OrderEntity> getOrders() {
		return repository.findAll();
	}

	@Override
	public OrderEntity createOrder(OrderEntity orderEntity) {
		return repository.save(orderEntity); 
	}

}

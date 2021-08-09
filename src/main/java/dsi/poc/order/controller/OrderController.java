package dsi.poc.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dsi.poc.order.model.OrderEntity;
import dsi.poc.order.service.OrderServiceImpl;

@RestController
@RequestMapping(value="/api/v1")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;


	//creating an order
	@PostMapping(value="/orders")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public OrderEntity newOrder(@Valid @RequestBody OrderEntity orderEntity){
		return orderServiceImpl.createOrder(orderEntity);
	}
     
	// get orders by id
	@GetMapping(value="/orders/{id}")
	public OrderEntity getOrderById(@PathVariable Long id) {
		return  orderServiceImpl.findById(id);
		
	}

     // get all the orders
	@GetMapping(value="/orders")
	public List<OrderEntity> getAllOrders(){
		return orderServiceImpl.getOrders();
	}

}

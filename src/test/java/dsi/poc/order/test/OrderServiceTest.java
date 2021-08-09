package dsi.poc.order.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import dsi.poc.order.model.OrderEntity;
import dsi.poc.order.repository.OrderJpaRepository;
import dsi.poc.order.service.OrderServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@MockBean
	private OrderJpaRepository orderJpaRepository;



	// test case for getting all the orders placed
	@Test
	public void getOrdersTest() {

		when(orderJpaRepository.findAll()).thenReturn(Stream.of(new OrderEntity( 1,"chair", 963420693,"sailikhith05@gmail.com","SaiLikhith")).collect(Collectors.toList()));
		assertEquals(1,orderServiceImpl.getOrders().size());

	}

	// test case for fetch orders by id
	@Test
	public void getOrderByTest() {
		
		OrderEntity orderEntity =  new OrderEntity(1L,"chair", 963420693,"sailikhith05@gmail.com","SaiLikhith");
		doReturn(Optional.of(orderEntity)).when(orderJpaRepository).findById(1L);
		Optional<OrderEntity> returnedOrderEntity = Optional.of(orderServiceImpl.findById(1L));
		Assertions.assertTrue(returnedOrderEntity.isPresent(),"order was not found");
		Assertions.assertSame(returnedOrderEntity.get(),orderEntity,"the order returned was not the same as mock");

	}
	
	
	// test case for creating orders
	@Test
	public void createOrderTest() {
		OrderEntity orderEntity =  new OrderEntity(1,"chair", 963420693,"sailikhith05@gmail.com","SaiLikhith");
		when(orderJpaRepository.save(orderEntity)).thenReturn(orderEntity);
		assertEquals(orderEntity,orderServiceImpl.createOrder(orderEntity));

	}

}

package com.product.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Order;
import com.product.Repository.OrderRepository;

@RestController
@RequestMapping("/api/")
public class OrderController {

	private final OrderRepository orderes;
	OrderController(OrderRepository orderes){
		this.orderes = orderes;
	}
	
	@GetMapping("/order/")
	List<Order> all(){
		return orderes.findAll();
	}
	
	@PostMapping("/order/")
	Order newOrder(@RequestBody Order newOrder) {
		return orderes.save(newOrder);
		
	}
	
	@GetMapping("/order/{id}")
	Order one(@PathVariable Long id) {
		return orderes.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
				
	}		
	
	@PutMapping("/order/{id}")
	Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
		return orderes.findById(id)
				.map(order -> {
					order.setUser_id(newOrder.getUser_id());
					order.setTime(newOrder.getTime());
					order.setAddress(newOrder.getAddress());
					order.setPhone(newOrder.getPhone());
					order.setTotal(newOrder.getTotal());
					order.setShip(newOrder.getShip());
					order.setFinalprice(newOrder.getFinalprice());
					order.setStatus(newOrder.getStatus());
					return orderes.save(order);
				})
				.orElseGet(() ->{
					newOrder.setId(id);
					return orderes.save(newOrder);
				});
	}
	
	@DeleteMapping("/order/{id}")
	void deleteOrder(@PathVariable Long id) {
		orderes.deleteById(id);
	}

}
